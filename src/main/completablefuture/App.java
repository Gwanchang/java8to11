package main.completablefuture;

public class App {

    public static void main(String[] args) {
        //Concurrent 소프트웨어 : 동시에 여러 작업을 할 수 있는 소프트웨어
        MyThread myThread = new MyThread();
        myThread.start();

        System.out.println("Hello");

        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread : " + Thread.currentThread().getName());

        });
        thread.start();

        /*
        Executors : 쓰레드를 만들고 관리하는 작업을 애플리케이션에서 분리.
                    그런 기능을 Executors에게 위임.
        */



    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Thread : " + Thread.currentThread().getName());
        }
    }
}
