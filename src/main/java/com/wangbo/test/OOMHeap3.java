package com.wangbo.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class OOMHeap3 {

    private static Map map = new HashMap();

    public static void main(String args[]) {
        Runtime.getRuntime().addShutdownHook(
                new Thread() {
                    @Override
                    public void run() {
                        try {
                            System.out.println("Enter something, so I'll release the process");
                            System.in.read();
                            System.out.println("We have accumulated " + map.size() + " entries");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );

        for (long i = 0; ; i++) {
            map.put(Long.toBinaryString(i), i);
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}