package org.example.extendThread;

public class HelloService extends Thread {

    @Override
    public void run() {
        for(int i=0; i<10; i++) {
            System.out.println("Hello");
        }
    }
}
