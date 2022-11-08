package main.executors;

import java.time.*;
import java.util.concurrent.*;

public class App {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> System.out.println("Thread " + Thread.currentThread().getName()));

        executorService.shutdown();

        ScheduledExecutorService scheduledExecutorService =
                Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(getRunnable("Hello"), 1, 2, TimeUnit.SECONDS);

        ExecutorService executorService1 = Executors.newSingleThreadExecutor();

        Callable<String> hello = () -> {
          Thread.sleep(2000L);
          return "Hello";
        };

        Future<String> submit = executorService1.submit(hello);
        System.out.println("Started!");

        submit.get(); // 블록킹

        System.out.println("End!");
        executorService1.shutdown();

    }

    private static Runnable getRunnable(String message) {
        return () -> System.out.println(message + Thread.currentThread().getName());
    }
}
