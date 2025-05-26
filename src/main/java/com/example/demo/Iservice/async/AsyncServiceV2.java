package com.example.demo.Iservice.async;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.stereotype.Service;

@Service
public class AsyncServiceV2 {
    private BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(100);
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition queueCondition = lock.newCondition();
    
    /**
     * The `increment` function locks a shared resource, increments a 
     * counter, and then unlocks the resource.
     */
    public void AddRequest(int number) {
        lock.lock();  // Aquire the lock
        System.out.println("Number: "+ number+ " got the lock");
        try {
            while (queue.size() > 90) {
            try {
                System.out.println("size of current queue and number is "+ queue.size()+" > 5 " + number);
                queueCondition.await();  // wait for signal, seem like this make some thread can jump
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted");
            }
            }

            queue.add(number);
        } finally {
            System.out.println("Number: " + number +" release lock");
            lock.unlock();  // Release the lock
        }
    }

    public void PopRequest() throws InterruptedException {
        lock.lock();
        try {
        Thread.sleep(3000);
        System.out.println("Number request poped is:  " + queue.poll());
        queueCondition.signalAll();
        }
        finally {
            lock.unlock();
        }
    }
}
