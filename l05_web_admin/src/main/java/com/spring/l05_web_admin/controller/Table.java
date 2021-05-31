package com.spring.l05_web_admin.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.spring.l05_web_admin.model.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class Table {
  @GetMapping(value = { "/basic_table" })
  public String basicTablePage(RedirectAttributes redirectAttr, HttpSession session, Model model) {
    if (session.getAttribute("loginUser") != null) {
      model.addAttribute("loginUser", session.getAttribute("loginUser"));
      model.addAttribute("activePage", "basic_table");

      return "table/basic_table";
    } else {
      redirectAttr.addFlashAttribute("message", "请先登录!");
      return "redirect:/login";
    }
  }

  @GetMapping(value = { "/dynamic_table" })
  public String dynamicTablePage(RedirectAttributes redirectAttr, HttpSession session, Model model) {
    if (session.getAttribute("loginUser") != null) {
      model.addAttribute("loginUser", session.getAttribute("loginUser"));
      model.addAttribute("activePage", "dynamic_table");

      return "table/dynamic_table";
    } else {
      redirectAttr.addFlashAttribute("message", "请先登录!");
      return "redirect:/login";
    }
  }

  @GetMapping(value = { "/editable_table" })
  public String editableTablePage(RedirectAttributes redirectAttr, HttpSession session, Model model) {
    if (session.getAttribute("loginUser") != null) {

      List<User> users = Arrays.asList(
        new User("eric", "123456", "管理员"), 
        new User("bob", "123456", "管理员"),
        new User("lisa", "123456", "管理员"), 
        new User("tom", "123456", "管理员"), 
        new User("jack", "123456", "管理员"),
        new User("jam", "123456", "管理员"), 
        new User("jinx", "123456", "管理员"), 
        new User("tomas", "123456", "管理员"),
        new User("helen", "123456", "管理员"), 
        new User("huck", "123456", "管理员"), 
        new User("giant", "123456", "管理员"),
        new User("mick", "123456", "管理员")
      );

      model.addAttribute("loginUser", session.getAttribute("loginUser"));
      model.addAttribute("activePage", "editable_table");
      model.addAttribute("users", users);
      return "table/editable_table";
    } else {
      redirectAttr.addFlashAttribute("message", "请先登录!");
      return "redirect:/login";
    }
  }

  @GetMapping(value = { "/pricing_table" })
  public String pricingTablePage(RedirectAttributes redirectAttr, HttpSession session, Model model) {
    if (session.getAttribute("loginUser") != null) {
      model.addAttribute("loginUser", session.getAttribute("loginUser"));
      model.addAttribute("activePage", "pricing_table");

      return "table/pricing_table";
    } else {
      redirectAttr.addFlashAttribute("message", "请先登录!");
      return "redirect:/login";
    }
  }

  @GetMapping(value = { "/responsive_table" })
  public String responsiveTablePage(RedirectAttributes redirectAttr, HttpSession session, Model model) {
    if (session.getAttribute("loginUser") != null) {
      model.addAttribute("loginUser", session.getAttribute("loginUser"));
      model.addAttribute("activePage", "responsive_table");

      return "table/responsive_table";
    } else {
      redirectAttr.addFlashAttribute("message", "请先登录!");
      return "redirect:/login";
    }
  }
}
