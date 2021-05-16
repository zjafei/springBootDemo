package com.springboot.l02_web_01.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
  @RequestMapping("/1.jpg")
  public String hello(){
    return "this is a page";
  }
}
