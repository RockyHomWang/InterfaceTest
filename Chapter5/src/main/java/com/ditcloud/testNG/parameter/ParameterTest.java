package com.ditcloud.testNG.parameter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {
    @Test
    @Parameters({"name","age"})
    public void test1(String name, int age){
        System.out.println("姓名：" + name + "\n" + "年龄：" + age);
    }
}

