package com.spring.l05_web_admin.controller;

import javax.servlet.http.HttpSession;

import com.spring.l05_web_admin.model.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Index {
  @GetMapping(value = { "/login" })
  public String loginPage() {
    return "login";
  }

  @PostMapping(value = { "/login" })
  public String login(
    User user,
    HttpSession session
  ) {
    if(StringUtils.hasText(user.getUsername())){ // TODO isEmpty 不给用了 
      
    }
    return "redirect:/main"; // redirect 重新定向到 main 对比直接提交数据到 main 页面可以避免页面刷新重复 post 提交数据
    /**
     * redirect 与 forward 的区别 
     * redirect url 会改变 
     * forward url 不会改变 目标页面等于原来页面的代理
     */
  }

  @GetMapping(value = { "/", "/main" })
  public String mainPage(
      Model model
    ) {
      System.out.println("-----------------");
      
    // model.addAttribute("username", username);
    return "main";
  }
}
