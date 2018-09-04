package com.wangbo.test;

public class HighCPU {
    public static void main(String args[]) {
        System.out.println("high");

        Thread t1 = new Thread(new EndlessloopThread());
        t1.start();
    }

}

class EndlessloopThread implements Runnable {
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