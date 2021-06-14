package com.spring.l05_web_admin.controller;

import javax.servlet.http.HttpSession;

import com.alibaba.druid.sql.dialect.oracle.ast.clause.OracleStorageClause.FlashCacheType;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.spring.l05_web_admin.model.User;

// import java.util.List;

import com.spring.l05_web_admin.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(value = { "/create" })
    public String formPage(Model model, HttpSession session) {
        model.addAttribute("message", session.getAttribute("message"));
        model.addAttribute("user", session.getAttribute("user"));
        session.removeAttribute("message");
        session.removeAttribute("user");
        model.addAttribute("activePage", "user");
        return "form/user_create";
    }

    @PostMapping(value = { "/create" })
    public String create(User user, Model model, HttpSession session) {
        System.out.println(user);
        model.addAttribute("activePage", "user");
        if (userService.save(user)) {
            session.setAttribute("message", "用户添加成功!");
            return "redirect:/user/list";
        } else {
            session.setAttribute("message", "用户添加失败!");
            session.setAttribute("user", user);
            return "redirect:/user/create";
        }
    }

    @GetMapping(value = { "/delete" })
    public String delete(@RequestParam(name = "id", required = true, defaultValue = "0") Long id, Model model,
            HttpSession session) {
        model.addAttribute("activePage", "user");
        if (userService.removeById(id)) {
            session.setAttribute("message", "用户删除成功!");
        } else {
            session.setAttribute("message", "用户删除sb!");
        }
        return "redirect:/user/list";
    }

    @GetMapping(value = { "/edit" })
    public String editPage(@RequestParam(name = "id", required = true, defaultValue = "0") Long id, Model model,
            HttpSession session) {
        model.addAttribute("activePage", "user");
        model.addAttribute("message", session.getAttribute("message"));
        session.removeAttribute("message");
        User user = userService.getById(id);
        if (user != null) {
            model.addAttribute("user", user);
        }
        return "form/user_edit";
    }

    @PostMapping(value = { "/edit" })
    public String editPage(User user, Model model, HttpSession session) {
        model.addAttribute("activePage", "user");
        if (userService.updateById(user)) {
            session.setAttribute("message", "用户编辑成功!");
            return "redirect:/user/list";
        } else {
            session.setAttribute("message", "用户编辑败!");
            return "redirect:/user/user_edit?id=" + user.getId();
        }
    }

    /**
     * 获取用户列表
     */
    @GetMapping(value = { "/list" })
    public String getList(
            @RequestParam(name = "keyword", required = false, defaultValue = "") String keyword,
            Model model, HttpSession session) {
        System.out.println(session.getAttribute("message"));
        model.addAttribute("message", session.getAttribute("message"));
        session.removeAttribute("message");
        model.addAttribute("activePage", "user");
        model.addAttribute("keyword", keyword);

        if(StringUtils.hasText(keyword)){
            QueryWrapper<User> keyworkQueryWrapper = new QueryWrapper<>();
            keyworkQueryWrapper.like("name", keyword);
            model.addAttribute("users", userService.list(keyworkQueryWrapper));
        }else{
            model.addAttribute("users", userService.list());
        }
        return "table/user_table";
    }
}
