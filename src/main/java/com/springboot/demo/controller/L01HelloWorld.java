package com.springboot.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class L01HelloWorld {
    @GetMapping("/hello")
    public String hello(){
        return "hello world!!!";
    }
}
