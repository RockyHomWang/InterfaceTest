package com.ditcloud.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@Api(value = "/",description = "这是我实现的所有get方法")
public class MyGetMethod {

    @RequestMapping(value = "/getCookies", method = RequestMethod.GET)
    /*
     * 给客户端返回cookies的接口
     */
    @ApiOperation(value = "通过这个方法可以获取到cookies",httpMethod = "GET")
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
    @ApiOperation(value = "这是一个需要携带正确的cookies才能访问的接口", httpMethod = "GET")
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
    @ApiOperation(value = "需要携带参数才能访问的get接口实现方式一", httpMethod = "GET")
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
    @ApiOperation(value = "这是必须携带参数的get请求实现方式二", httpMethod = "GET")
    public Map<String, Integer> myGetList(@PathVariable Integer start,
                                          @PathVariable Integer end){

        Map<String, Integer> myList = new HashMap<>();

        myList.put("白沙",10);
        myList.put("小浣熊泡面",1);
        myList.put("火腿肠",3);

        return myList;
    }
}
