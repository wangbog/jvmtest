package com.wangbo.test;

import java.util.HashMap;
import java.util.Map;

public class OOMHeap {

    private static Map map = new HashMap();

    public static void main(String args[]) {
        Runtime.getRuntime().addShutdownHook(
                new Thread() {
                    @Override
                    public void run() {
                        System.out.println("We have accumulated " + map.size() + " entries");
                    }
                }
        );

        for (long i = 0; ; i++) {
            map.put(Long.toBinaryString(i), i);
        }
    }

}