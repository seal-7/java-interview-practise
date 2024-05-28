package org.example.syncronization;

public class Counter {
    int counter;

    public Counter() {
        this.counter = 0;
    }

    public synchronized void increment() {
//        synchronized (this) {
            counter++;
//        }
    }

    public int getCounter() {
        return counter;
    }
}
