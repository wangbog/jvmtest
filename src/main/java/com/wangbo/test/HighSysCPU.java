package com.wangbo.test;

public class HighSysCPU {
    public static void main(String args[]) {
        System.out.println("high");

        for (int i = 0; i < 8000; i++) {
            Thread t1 = new Thread(new EndlessloopThread3());
            t1.start();
        }

    }

}

class EndlessloopThread3 implements Runnable {
    @Override
    public void run() {
        long i = 0;
        while (true) {
            i++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}