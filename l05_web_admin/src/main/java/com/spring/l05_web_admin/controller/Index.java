package com.spring.l05_web_admin.controller;

// import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.spring.l05_web_admin.mapper.CityMapper;
import com.spring.l05_web_admin.model.City;
import com.spring.l05_web_admin.model.HelpTopic;
import com.spring.l05_web_admin.model.User;
import com.spring.l05_web_admin.service.CityService;
// import com.spring.l05_web_admin.model.Util;
import com.spring.l05_web_admin.service.HelpTopicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class Index {

  @Autowired
  JdbcTemplate jdbcTemplate;

  @ResponseBody
  @GetMapping("/query")
  public String query() {
    Long aLong = jdbcTemplate.queryForObject("select count(*) from innodb_index_stats", Long.class);
    return aLong.toString();
  }

  @Autowired
  HelpTopicService helpTopicService;

  @ResponseBody
  @GetMapping("/help_top")
  public HelpTopic getByHelpTopicId(@RequestParam("id") Long id) {
    return helpTopicService.getHelpTopic(id);
  }

  @Autowired
  CityService cityService;

  @ResponseBody
  @GetMapping("/city")
  public City getCityById(@RequestParam("id") Long id) {
    return cityService.getById(id);
  }

  @ResponseBody
  @PostMapping("/city")
  public City insertCity(City city) {
    cityService.insert(city);
    return city;
  }

  @GetMapping(value = { "/login" })
  public String loginPage(
      // @ModelAttribute("message") String message,
      // HttpServletRequest request,
      Model model, HttpSession session) {
    // request.getAttribute("message");

    model.addAttribute("message", session.getAttribute("message"));
    session.removeAttribute("message");
    return "login";
  }

  @PostMapping(value = { "/login" })
  public String login(
      // RedirectAttributes redirectAttr,
      // HttpServletRequest request,
      User user, HttpSession session) {
    if (StringUtils.hasText(user.getUsername()) && "111111".equals(user.getPassword())) { // TODO isEmpty 不给用了
      session.setAttribute("loginUser", user); // 把登陆成功的用户保存起来
      return "redirect:/main"; // redirect 重新定向到 main 对比直接提交数据到 main 页面可以避免页面刷新重复 post 提交数据
    } else {
      // request.setAttribute("message", "用户名或密码错误");
      session.setAttribute("message", "用户名或密码错误!");
      // redirectAttr.addFlashAttribute("message", "用户名或密码错误!"); // redirect 时利用
      // session 来传递值
      return "redirect:/login";
    }

    /**
     * redirect 与 forward 的区别 redirect url 会改变 forward url 不会改变 目标页面等于原来页面的代理
     */
  }

  @GetMapping(value = { "/", "/main" })
  public String mainPage(RedirectAttributes redirectAttr, Model model) {
    model.addAttribute("activePage", "main");
    return "main";
  }

  @GetMapping(value = { "/logout" })
  public String logout(RedirectAttributes redirectAttr, HttpSession session) {
    session.removeAttribute("loginUser");
    redirectAttr.addFlashAttribute("message", "成功退出!");
    return "redirect:/login";
  }
}
