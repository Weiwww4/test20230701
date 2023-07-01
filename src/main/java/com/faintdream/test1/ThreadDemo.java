package com.faintdream.test1;

public class ThreadDemo extends Thread {

    // private String threadName;

    public ThreadDemo(String name) {
        super(name);
    }

    public ThreadDemo() {
        super();
    }

    public static void main(String[] args) {
        Thread thread1 = new ThreadDemo("Thread-001");
        thread1.start();
        Thread thread2 = new ThreadDemo("Thread-001");
        thread2.start();
    }

    //
    public void run() {
        System.out.println("Thread:" + getName() + "starting");
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread:" + getName() + " : " + i);
        }
        System.out.println("Thread:" + getName() + "exiting");
    }
}
