package com.ditcloud.testNG.parameter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataProviderTest {

    @Test(dataProvider = "data")
    public void testDataProvider(String name,int age){
        System.out.println("name" + name + "\n" + "age" +age);
    }

    @DataProvider(name = "data")
    public Object[][] providerData(){
        Object[][] object = new Object[][]{
                {"data1",11},
                {"data2",12},
                {"data3",13}
        };
        return object;
    }

    @Test(dataProvider = "methodData")
    public void test1(String name,int age){
        System.out.println("执行test1方法:" + "\n" + "姓名：" + name + "\n" + "年龄：" + age );
    }

    @Test(dataProvider = "methodData")
    public void test2(String name,int age){
        System.out.println("执行test2方法:" + "\n"  + "姓名：" + name + "\n" + "年龄：" + age );
    }

    @DataProvider(name = "methodData")
    public Object[][] methodDataProviderTest(Method method){

        Object[][] obj = null;

        if(method.getName().equals("test1")){
            obj = new Object[][]{
                    {"zhaoyi",10},
                    {"qianer",11}
            };
        }
        else if (method.getName().equals("test2")){
            obj = new Object[][]{
                    {"sunsan",12},
                    {"lisi",13}
            };
        }
        return obj;
    }
}
