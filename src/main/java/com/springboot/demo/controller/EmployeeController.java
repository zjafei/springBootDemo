package com.springboot.demo.controller;

import java.util.Collection;

// import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.springboot.demo.model.Employee;
import com.springboot.demo.dao.EmployeeDao;
import com.springboot.demo.model.Department;
import com.springboot.demo.dao.DepartmentDao;

@Controller
public class EmployeeController {

  @Autowired
  EmployeeDao employeeDao;

  @Autowired
  DepartmentDao departmentDao;

  @GetMapping(value = "/emps")
  public String list(Model model) {
    Collection<Employee> employees = employeeDao.getAll();
    model.addAttribute("emps", employees);
    return "emp/list";
  }

  @GetMapping("/emp")
  public String addPage(Model model) {
    Collection<Department> departments = departmentDao.getDepartments();
    model.addAttribute("depts", departments);
    return "emp/empForm";
  }

  // springMVC会把入参的参数属性于对象属性一一绑定
  @PostMapping("/emp")
  public String addEmp(Employee employee) {
    // redirect 重定向 /代表当前项目路径
    // forward 转发
    System.out.println("post:------------------------------------- ");
    System.out.println(employee);
    employeeDao.save(employee);
    return "redirect:/emps";
  }

  @DeleteMapping("/emp/{id}")
  public String editPage(@PathVariable("id") Integer id) {
    employeeDao.delete(id);
    return "redirect:/emps";
  }

  @GetMapping("/emp/{id}")
  public String editPage(@PathVariable("id") Integer id, Model model) {
    model.addAttribute("depts", departmentDao.getDepartments());
    model.addAttribute("emp", employeeDao.get(id));
    return "emp/empForm";
  }

  @PutMapping("/emp")
  public String editEmp(Employee employee) {
    // redirect 重定向 /代表当前项目路径
    // forward 转发
    System.out.println("put:------------------------------------- ");
    System.out.println(employee);
    employeeDao.save(employee);
    return "redirect:/emps";
  }
}
