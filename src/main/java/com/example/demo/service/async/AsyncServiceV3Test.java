package com.example.demo.service.async;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.stereotype.Service;
import java.time.Duration;
import java.time.LocalDateTime;

@Service
public class AsyncServiceV3Test {
    
    private final BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(100);

    /**
     * The `increment` function locks a shared resource, increments a 
     * counter, and then unlocks the resource.
     */
    public synchronized void AddRequest(int number) {
        
        
        try {
            System.out.println("Number: "+ number+ " jump into function with queue size "+ queue.size());
            //Thread.sleep(10);
            while (queue.remainingCapacity() == 0) {
                wait();   // another thread can jump
            }
            queue.add(number);
            System.out.println("Number "+ number +" is add release lock with queue size "+ queue.size());
            notifyAll();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

    public synchronized void PopRequest() throws InterruptedException{
        while (true) {
        
            while (!queue.isEmpty()) {
    
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println("Number request poped is:  " + queue.poll() +" and queue size: " + queue.size());
            }; 
        
            notifyAll();
            wait();
            
        }
    }
        
    }

