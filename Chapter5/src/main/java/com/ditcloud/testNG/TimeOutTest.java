package com.ditcloud.testNG;

import org.junit.rules.Timeout;
import org.testng.annotations.Test;

public class TimeOutTest {
    @Test(timeOut = 3000)
    public void timeOutTestSuccess() throws InterruptedException{
        Thread.sleep(2000);
    }

    @Test(timeOut = 2000)
    public void timeOutTestFailed() throws InterruptedException{
        Thread.sleep(3000);
    }
}
