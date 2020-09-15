package com.rabbitmq.provider.controller;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        //等凉菜
        Callable callable1 = new Callable() {
            @Override
            public Object call() throws Exception {
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException  e){
                    e.printStackTrace();
                }
                return Thread.currentThread().getName();
            }
        };
        FutureTask<String> futureTask1 = new FutureTask(callable1);
        Thread thread1 = new Thread(futureTask1);

        //等热菜
        Callable callable2 = new Callable() {
            @Override
            public Object call() throws Exception {
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException  e){
                    e.printStackTrace();
                }
                return Thread.currentThread().getName();
            }
        };
        FutureTask<String> futureTask2 = new FutureTask(callable2);
        Thread thread2 = new Thread(futureTask2);
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.execute(thread1);
        service.execute(thread2);
        System.out.println(futureTask1.get());
        System.out.println(futureTask2.get());
        long end = System.currentTimeMillis();
        System.out.println("准备完毕时间："+(end-start));
    }
}
