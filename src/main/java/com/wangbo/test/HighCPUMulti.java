package com.wangbo.test;

public class HighCPUMulti {
    public static void main(String args[]) {
        System.out.println("hello");

        Thread t1 = new Thread(new EndlessloopThread2());
        Thread t2 = new Thread(new EndlessloopThread2());
        t1.start();
        t2.start();
    }

}

class EndlessloopThread2 implements Runnable {
    @Override
    public void run() {
        long i = 0;
        while (true) {
            i++;
            if (i % 10000000 == 0) {
                System.out.println(Thread.currentThread().getName() + " -> " + i);
            }
        }
    }
}