package com.spring.boot.boot_01_helloworld_2.controller;

import com.spring.boot.boot_01_helloworld_2.bean.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

  @Autowired
  Person person;

  @RequestMapping("/person")
  public Person person() {
    System.out.println("-----------------");
    return person;
  }
}
