package me.pepeprmill.java8Practice;

import java.util.concurrent.*;

public class AsyncEx {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Future<String> submit = executorService.submit(() -> "hello");

        // Blocking call
//        submit.get();

        CompletableFuture<String> objectCompletableFuture = new CompletableFuture<>();
        objectCompletableFuture.complete("pepper mill");
        System.out.println("objectCompletableFuture = " + objectCompletableFuture.get());

        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName());
        });
        future.get();

        CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            return "hello";
        });
        System.out.println("supplyAsync = " + supplyAsync.get());

        CompletableFuture<String> supplyAsync2 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            return "hello2";
        }).thenApply( (s) -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("s = " + s);
            return s.toUpperCase();
        });

        System.out.println("supplyAsync2 = " + supplyAsync2.get());

        CompletableFuture<Void> supplyAsync3 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            return "hello3";
        }).thenAccept( (s) -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("s = " + s);
        });

        System.out.println("supplyAsync3 = " + supplyAsync3);

        CompletableFuture<Void> supplyAsync4 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            return "hello4";
        }, executorService).thenRun( () -> {
            System.out.println(Thread.currentThread().getName());
        });

        executorService.shutdown();
    }
}
