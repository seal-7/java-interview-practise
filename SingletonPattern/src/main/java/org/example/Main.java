package org.example;

import org.example.models.SingletonClass;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<20;i++) {
                    System.out.println(SingletonClass.getInstance().hashCode());
                }
            }
        };

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<20;i++) {
                    System.out.println(SingletonClass.getInstance().hashCode());
                }
            }
        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}