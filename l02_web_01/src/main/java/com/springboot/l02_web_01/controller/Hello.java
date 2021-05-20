package com.springboot.l02_web_01.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
  @RequestMapping("/1.jpg")
  public String hello(){
    return "this is a page";
  }

  @PostMapping("/user")
  public String saveUser(){
    return "post add user";
  }

  @DeleteMapping("/user")
  public String deleteUser(){
    return "delete delete user";
  }

  @PutMapping("/user")
  public String editUser(){
    return "put edit user";
  }

  @GetMapping("/user")
  public String getUser(){
    return "get get user";
  }

  @PatchMapping("/user")
  public String updateUser(){
    return "patch edit user";
  }

}
