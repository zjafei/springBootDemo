package com.spring.l05_web_admin.controller;

import javax.servlet.http.HttpSession;

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
      return "table/dynamic_table";
    } else {
      redirectAttr.addFlashAttribute("message", "请先登录!");
      return "redirect:/login";
    }
  }

  @GetMapping(value = { "/editable_table" })
  public String editableTablePage(RedirectAttributes redirectAttr, HttpSession session, Model model) {
    if (session.getAttribute("loginUser") != null) {
      model.addAttribute("loginUser", session.getAttribute("loginUser"));
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
      return "table/responsive_table";
    } else {
      redirectAttr.addFlashAttribute("message", "请先登录!");
      return "redirect:/login";
    }
  }
}
