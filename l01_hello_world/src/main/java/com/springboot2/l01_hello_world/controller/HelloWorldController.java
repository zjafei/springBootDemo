package com.springboot2.l01_hello_world.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class HelloWorldController {
  @RequestMapping("/hello")
  public String handle01(){
    log.info("请求进来了_____________________________");
    return "Hello spring boot 2!!!";
  }
}
