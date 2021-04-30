package com.springboot.demo.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.springboot.demo.model.Employee;
import com.springboot.demo.dao.EmployeeDao;

@Controller
public class EmployeeController {

  @Autowired
  EmployeeDao employeeDao;

  @GetMapping(value = "/emps")
  public String list(Model model) {
    Collection<Employee> employees = employeeDao.getAll();
    model.addAttribute("emps", employees);
    return "emp/list";
  }
}