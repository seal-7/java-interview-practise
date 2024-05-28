package org.example;

import org.example.syncronization.ASyncRunnable;
import org.example.syncronization.BSyncRunnable;
import org.example.syncronization.Counter;

public class Main {
    public static void main(String[] args) {


//        HiService hiService = new HiService();
//        HelloService helloService = new HelloService();
//        hiService.start();
//        helloService.start();

        /*
        ARunnable aRunnable = new ARunnable();
        BRunnable bRunnable = new BRunnable();
        Runnable cRunnable = () -> {
            for (int i=0; i<20; i++) {
                System.out.println("Printing C");
            }
        };
        Thread thread1 = new Thread(aRunnable);
        Thread thread2 = new Thread(bRunnable);
        Thread thread3 = new Thread(cRunnable);
        thread1.start();
        thread2.start();
        thread3.start();
        */

        Counter counter = new Counter();
        ASyncRunnable aRunnable = new ASyncRunnable(counter);
        BSyncRunnable bRunnable = new BSyncRunnable(counter);
        Thread thread1 = new Thread(aRunnable);
        Thread thread2 = new Thread(bRunnable);
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(counter.getCounter());
    }
}