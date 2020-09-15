package com.ditcloud.testNG;


import org.testng.annotations.*;

public class Basic {
    @Test
    public void testcase1(){
        System.out.println("@Test这是测试用例1");
    }

    @BeforeMethod
    public  void beforeMethod(){
        System.out.println("@BeforeMethod这是在测试方法之前执行");
    }

    @AfterMethod
    public  void afterMethod(){
        System.out.println("@AfterMethod这是在测试方法之后执行");
    }

    @BeforeClass
    public  void beforeClass(){
        System.out.println("@BeforeClass这是在测试类之前执行");
    }

    @AfterClass
    public void afterClass(){

        System.out.println("@AfterClass这是在测试类之后执行");
    }

    @BeforeSuite
    public  void beforeSuite(){
        System.out.println("@BeforeSuite这是在测试套件之前执行");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("@AfterSuite这是在测试套件之后执行");
    }

}
