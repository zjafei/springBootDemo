package com.springboot.demo.controller;

import com.springboot.demo.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;


@Controller
public class Test {
    @GetMapping("/ok")
    public String ok(Map<String, Object>map){
        map.put("name","马正");
        return "no";
    }
    @GetMapping("/no")
    public String no(Model model){
        model.addAttribute("person","eric ma");
        return "ok";
    }
}

