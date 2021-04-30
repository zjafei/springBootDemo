package com.springboot.demo.controller;

import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {

  @RequestMapping(value = "/user/logout")
  public String logout(Map<String, Object> map, HttpSession session) {
    map.put("msg", "成功退出");
    session.removeAttribute("loginUser");
    return "login";
  }
}