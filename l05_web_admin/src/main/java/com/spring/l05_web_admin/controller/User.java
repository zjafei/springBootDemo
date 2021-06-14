package com.spring.l05_web_admin.controller;

import com.spring.l05_web_admin.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class User {
    @Autowired
    UserService userService;
    /**
     * 获取用户列表
     */
    @GetMapping(value = { "/{pageNo}" })
    public String getList(@PathVariable("pageNo") Integer pageNo) {
        return "table/dynamic_table";
    }
}
