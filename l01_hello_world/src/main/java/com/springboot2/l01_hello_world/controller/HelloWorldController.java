package com.springboot2.l01_hello_world.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
  
  @RequestMapping("/hello")
  public String handle01(){
    return "hello spring boot 2";
  }
}
