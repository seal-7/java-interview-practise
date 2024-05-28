package org.example.extendThread;

import java.util.concurrent.locks.ReentrantLock;

public class HiService extends Thread {

    @Override
    public void run() {
        for(int i=0; i<10; i++) {
            System.out.println("Hi");
        }
    }
}
