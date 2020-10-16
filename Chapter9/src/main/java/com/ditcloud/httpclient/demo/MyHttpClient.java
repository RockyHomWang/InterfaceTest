package com.ditcloud.httpclient.demo;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class MyHttpClient {
    @Test
    public void test1() throws IOException {
        //用来存放我们的结果
        HttpGet get = new HttpGet("http://www.baidu.com");
        //这个是用来执行get()方法的
        HttpClient client = new DefaultHttpClient();
        HttpResponse response;
        response = client.execute(get);

        String result = EntityUtils.toString(response.getEntity(), "utf-8");

        System.out.println(result);

    }
}


