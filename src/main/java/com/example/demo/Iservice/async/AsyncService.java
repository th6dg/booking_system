package com.example.demo.Iservice.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class AsyncService {

    // Annotating the method with @Async to run it in a separate thread
    @Async
    public void processTask() throws InterruptedException {
        System.out.println("Started processing task in thread: " + Thread.currentThread().getName());

        // Simulate a time-consuming task (e.g., a long computation, IO operation, etc.)
        TimeUnit.SECONDS.sleep(5); // Simulate a delay of 5 seconds

        System.out.println("Finished processing task in thread: " + Thread.currentThread().getName());
    }

    // You can return a Future, CompletableFuture, or ListenableFuture if you want to capture the result
    @Async
    public void anotherAsyncTask() {
        System.out.println("Started another task in thread: " + Thread.currentThread().getName());
    }
}
