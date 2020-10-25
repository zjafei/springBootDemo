package com.springboot.demo.controller;

import com.springboot.demo.model.Person;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HelloWorld {
    @GetMapping(value = "/test")
    public ModelAndView test(){
        ModelAndView mv = new ModelAndView();
        mv.addObject( "person", new Person("eric"));
        return mv;
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello world!!!";
    }

    @RequestMapping("/articleList")
    public String getArticleList(Model model) {
        model.addAttribute("firstName", "ma");
        return "articleList";
    }
}

