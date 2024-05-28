package org.example.syncronization;

public class BSyncRunnable implements Runnable {

    final Counter counter;

    public BSyncRunnable(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for(int i=0;i<200;i++) {
            counter.increment();
        }
    }
}
