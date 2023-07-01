package com.faintdream;

public class RunnableDemo implements Runnable {
    private Thread thread;
    private String threadName;

    public RunnableDemo(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        System.out.println("Running: " + threadName);
        try {
            for (int i = 0; i < 4; i++) {
                System.out.println("Thread: " + threadName + ", " + i);
                // Pause 50 millis
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread: " + threadName + " exiting");
    }

    public void start() {
        System.out.println("Starting " + threadName);
        if (thread == null) {
            thread = new Thread(this, threadName);
            thread.start();
        }
    }

    public static void main(String[] args) {
        RunnableDemo r1 = new RunnableDemo("thread-1");
        r1.start();
        RunnableDemo r2 = new RunnableDemo("thread-2");
        r2.start();
    }
}