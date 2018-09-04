package com.wangbo.test;

import java.util.HashMap;
import java.util.Map;

public class Hook {

    private static Map map = new HashMap();

    public static void main(String args[]) {
        Runtime.getRuntime().addShutdownHook(
                new Thread() {
                    @Override
                    public void run() {
                        System.out.println("SIGNAL received");
                    }
                }
        );

        while (true) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}