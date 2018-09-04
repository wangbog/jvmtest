package com.wangbo.test;

import java.util.Date;

public class DeadLock {

    public static String obj1 = "obj1";
    public static String obj2 = "obj2";

    public static void main(String[] args) {
        LockA la = new LockA();
        LockB lb = new LockB();

        new Thread(la).start();
        new Thread(lb).start();
    }

}

class LockA implements Runnable {
    public void run() {
        try {
            System.out.println(new Date().toString() + " LockA started");
            while (true) {
                synchronized (DeadLock.obj1) {
                    System.out.println(new Date().toString() + " LockA locking obj1");
                    Thread.sleep(3000); // here we wait so B has a chance to lock
                    synchronized (DeadLock.obj2) {
                        System.out.println(new Date().toString() + " LockA locked obj2");
                        Thread.sleep(60 * 1000); // just for test. hold the lock
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class LockB implements Runnable {
    public void run() {
        try {
            System.out.println(new Date().toString() + " LockB started");
            while (true) {
                synchronized (DeadLock.obj2) {
                    System.out.println(new Date().toString() + " LockB locking obj2");
                    Thread.sleep(3000); // here we wait so A has a chance to lock
                    synchronized (DeadLock.obj1) {
                        System.out.println(new Date().toString() + " LockB locked obj1");
                        Thread.sleep(60 * 1000); // just for test. hold the lock
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
