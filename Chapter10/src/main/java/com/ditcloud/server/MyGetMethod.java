package com.ditcloud.server;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
public class MyGetMethod {

    @RequestMapping(value = "/getCookies", method = RequestMethod.GET)
    /*
     * 给客户端返回cookies的接口
     */
    public String getCookies(HttpServletResponse response){
        //HttpServletRequest 装请求信息的类
        //HttpServletResponse 装响应信息的类
        Cookie cookie = new Cookie("login","true");
        response.addCookie(cookie);

        return "获取cookies成功！";
    }

    /*
     * 要求客户端携带cookies访问
     * 这是一个需要携带cookies信息才能访问的get请求
     */
    @RequestMapping(value = "/get/with/cookies", method = RequestMethod.GET)
    public String getWithCookies(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if (Objects.isNull(cookies)){
            return "该请求必须携带cookies信息";
        }
        for (Cookie cookie : cookies){
            if (cookie.getName().equals("login") && cookie.getValue().equals("true")){
                return "恭喜成功登录！";
            }
        }
        return "cookies信息不正确";
    }

    /**
     * 开发一个需要携带参数才能访问的get请求
     * 实现方式一：url: key=value&key=value
     * 业务场景：模拟获取商品列表
     */
    @RequestMapping(value = "get/with/param", method = RequestMethod.GET)
    public Map<String,Integer> getList(@RequestParam Integer start,
                                       @RequestParam Integer end){
        Map<String, Integer> myList = new HashMap<>();

        myList.put("白沙",10);
        myList.put("小浣熊泡面",1);
        myList.put("火腿肠",3);

        return myList;
    }

    /**
     *实现方式二：需要携带参数访问的get请求
     */
    @RequestMapping(value = "/get/with/param/{start}/{end}")
    public Map myGetList(@PathVariable Integer start,
                         @PathVariable Integer end){

        Map<String, Integer> myList = new HashMap<>();

        myList.put("白沙",10);
        myList.put("小浣熊泡面",1);
        myList.put("火腿肠",3);

        return myList;
    }
}
