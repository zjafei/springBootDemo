package com.springboot.l02_web_01.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParameterTest {
  @GetMapping("/car/{id}/owner/{username}")
  public Map<String, Object> getCar(
      @PathVariable("id") Integer id, @PathVariable("username") String name, // 获取具体的路径参数
      @PathVariable Map<String, String> pathVariable, // 获取所有的路径参数
      @RequestHeader("User-Agent") String userAgent, // 获取具体的请求头
      @RequestHeader Map<String, String> requestHeader, // 获取所有的请求头
      @RequestParam(value = "age", required = false, defaultValue = "20") Integer age, // 获取具体请求参数
      @RequestParam(value = "inters", required = false, defaultValue = "ball,game") List<String> interList, // 获取具体请求参数
      @RequestParam Map<String, String> requestParam, // 获取所有请求参数
      @CookieValue(value = "_ga", required = false) String ga, // 获取具体cookie的值
      @CookieValue(value = "_ga", required = false) Cookie cookie // 获取具体cookie所有参数
      // @RequestBody Map<String, String> requestBody // 获取所有 requestBody
  ) {
    Map<String, Object> map = new HashMap<>();
    // Map<String,Object> 表示 name是String 类型，Object是value的类型
    // Map<Object,String> 表示 name是Object 类型，String是value的类型

    map.put("id", id);
    map.put("name", name);
    map.put("age", age);
    map.put("inters", interList);
    map.put("requestParam", requestParam);
    map.put("pathVariable", pathVariable);
    map.put("userAgent", userAgent);
    map.put("requestHeader", requestHeader);
    map.put("ga", ga);
    map.put("cookie", cookie);
    // map.put("requestBody", requestBody);

    return map;
  }
}
