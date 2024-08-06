package org.bgd.java.ds.multithreaded;

public class FooBarMultipleThreads {
    private int oddEven;

    static Runnable foo = new Runnable() {
        @Override
        public void run() {
            System.out.println("Foo");
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.notify();
        }
    };

    static Runnable bar = new Runnable() {
        @Override
        public void run() {
            System.out.println("Bar");
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.notify();
        }
    };

    FooBarMultipleThreads() {
        this.oddEven = 5;
    }

    public static void main(String[] args) {
        FooBarMultipleThreads m = new FooBarMultipleThreads();
        Thread t1 = new Thread(foo);
        Thread t2 = new Thread(foo);

        t1.start();
        t2.start();
    }

}
