package com.example.demo.serviceImpl.book;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.springframework.stereotype.Service;

import com.example.demo.Iservice.book.IBorrowBook;

@Service
public class BorrowBookV1 implements IBorrowBook {

    private final BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(100);

    @Override
    public synchronized void AddRequest(int number){
        System.out.println("Add request...");
        while(queue.remainingCapacity() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        queue.add(number);
        notifyAll();
    }

    @Override
    public void ProcessRequest(int number) {
        System.out.println("Process Request");
        
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

    public synchronized void PopRequest(int number) {
        while(!queue.isEmpty()) {
            
            queue.poll();
        }
        System.out.println("Pop Request");
    }

    

}
