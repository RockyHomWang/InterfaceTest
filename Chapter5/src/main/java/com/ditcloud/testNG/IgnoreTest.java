package com.ditcloud.testNG;

import org.testng.annotations.Test;

public class IgnoreTest {

    @Test
    public void ignore1(){
        System.out.println("ignore1()执行！");
    }

    @Test(enabled = false)
    public void ingnore2(){
        System.out.println("ignore2()执行！");
    }

    @Test(enabled = true)
    public void ingnore3(){

        System.out.println("ignore3()执行！");
    }

}
