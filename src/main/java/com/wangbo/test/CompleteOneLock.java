package com.wangbo.test;

import java.util.Date;

public class CompleteOneLock {

    public static String obj1 = "obj1";

    public static void main(String[] args) {

        for (int i = 0; i < 80; i++) {
            LockOne tLock = new LockOne(i);
            new Thread(tLock).start();
        }

    }
}

class LockOne implements Runnable {
    private int name;

    public LockOne(int name){
        this.name = name;
    }

    public void run() {
        try {
            System.out.println(new Date().toString() + " LockOne started:" + this.name);
            while (true) {
                synchronized (DeadLock.obj1) {
                    System.out.println(new Date().toString() + " LockOne locked obj1: " + this.name);
                    Thread.sleep(60 * 1000); // 为测试，占用了就不放
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}