package com.ditcloud.testNG;

import org.testng.annotations.Test;

public class ExpectException {
    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionFailed(){
        System.out.println("这是一个失败的异常测试");
    }

    //这是一个成功的异常测试
    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionSuccess(){
        System.out.println("异常测试结果：success");
        throw new RuntimeException();
    }
}
