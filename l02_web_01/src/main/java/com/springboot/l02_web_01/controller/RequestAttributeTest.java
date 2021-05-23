package com.springboot.l02_web_01.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RequestAttributeTest {
  @GetMapping("/go")
  public String go(HttpServletRequest request) {
    request.setAttribute("name", "eric");
    request.setAttribute("code", 20);
    return "forward:/success";
  }

  @ResponseBody
  @GetMapping("/success")
  public Map<String, Object> success(
    @RequestAttribute(value = "name", required = false) String name, // 获取所有的请求头
    @RequestAttribute(value = "code", required = false) Integer code, // 获取所有的请求头
    HttpServletRequest request
  ) {
    Map<String, Object> map = new HashMap<>();
    map.put("name", name);
    map.put("code", request.getAttribute("code"));
    return map;
  }
}
