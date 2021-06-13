package com.spring.l05_web_admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class User {

    /**
     * 获取用户列表
     */
    @GetMapping(value = { "/{pageNo}" })
    public String getList(@PathVariable("id") Integer id) {
        return "table/dynamic_table";
    }
}
