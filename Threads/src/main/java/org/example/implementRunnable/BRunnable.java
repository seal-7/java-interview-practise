package org.example.implementRunnable;

public class BRunnable implements Runnable {
    @Override
    public void run() {
        for(int i=0;i<20;i++) {
            System.out.println("Printing B");
        }
    }
}
