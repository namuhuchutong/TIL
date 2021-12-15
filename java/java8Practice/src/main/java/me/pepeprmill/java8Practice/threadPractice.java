package me.pepeprmill.java8Practice;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class threadPractice {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> helloFuture = executorService.submit(() -> {
            Thread.sleep(2000L);
            return "Callable";
        });
        System.out.println("Hello");
        String result = helloFuture.get();
        System.out.println(result);
        executorService.shutdown();
    }
}
