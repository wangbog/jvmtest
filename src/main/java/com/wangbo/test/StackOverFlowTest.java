package com.wangbo.test;

public class StackOverFlowTest {

    public long stackLength = 0;

    public void stackOverflow() {
        ++stackLength;
        stackOverflow();
    }

    public static void main(String args[]) {

        StackOverFlowTest stackOverFlowTest = new StackOverFlowTest();

        try {
            stackOverFlowTest.stackOverflow();
        } catch (Throwable e) {
            System.out.println("stack length: " + stackOverFlowTest.stackLength);
            //e.printStackTrace();
        }
    }

}