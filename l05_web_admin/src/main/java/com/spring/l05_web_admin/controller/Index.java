package com.spring.l05_web_admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Index {
  @GetMapping("/login")
  public String login() {
    return "login";
  }
}
