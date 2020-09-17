package com.ditcloud.testNG.multithreading;

import org.testng.annotations.Test;

public class MultiThreadingTestOnXML {
    @Test
    public void test1(){
        System.out.printf("Thread ID: %s%n",Thread.currentThread().getId());
    }

    @Test
    public void test2(){
        System.out.printf("Thread ID: %s%n",Thread.currentThread().getId());
    }

    @Test
    public void test3(){
        System.out.printf("Thread Id: %s%n", Thread.currentThread().getId());
    }
}
