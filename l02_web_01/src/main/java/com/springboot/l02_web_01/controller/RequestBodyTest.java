package com.springboot.l02_web_01.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestBodyTest {
  @PostMapping("/save")
  public Map<String, Object> getCar(
    @RequestBody String requestBody // 获取所有 requestBody
  ) {
    Map<String, Object> map = new HashMap<>();
    map.put("requestBody", requestBody);
    return map;
  }
}
