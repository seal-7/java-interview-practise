package org.example.syncronization;

public class ASyncRunnable implements Runnable {
    final Counter counter;

    public ASyncRunnable(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for(int i=0;i<200;i++) {
            counter.increment();
        }
    }
}
