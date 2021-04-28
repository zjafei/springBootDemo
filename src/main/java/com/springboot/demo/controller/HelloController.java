package com.springboot.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.Map;


@Controller
public class HelloController {
//    @RequestMapping({"/", "/index.html"})
//    public String index(){
//        return "index";
//    }

    @GetMapping("/hello")
    public String hello(){
        return "hello world!!!";
    }

    @RequestMapping("/success")
    public String success(Map<String, Object> map) {
        map.put("hello","你好");
        map.put("users", Arrays.asList("张三", "李四", "王五"));
        return "success";
    }
}

