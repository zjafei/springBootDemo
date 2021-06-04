package com.spring.l05_web_admin.controller;

import java.io.IOException;

import com.spring.l05_web_admin.model.Util;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class Form {
  @GetMapping(value = { "/form_basic" })
  public String formLayouts(Model model) {
    model.addAttribute("activePage", "form_basic");
    return "form/form_basic";
  }

  /***
   * 
   * @param username
   * @param email
   * @param headImg
   * @param photos
   * @return
   * @throws IOException
   * @throws IllegalStateException
   */
  @PostMapping(value = { "create_user" })
  public String createUser(@RequestParam(value = "username") String username, //
      @RequestParam(value = "email") String email, @RequestPart(value = "headImg") MultipartFile headImg,
      @RequestPart(value = "photos") MultipartFile[] photos) throws IllegalStateException, IOException {

    Util.createUploadFile(headImg);
    if (photos.length > 0) {
      for (MultipartFile photo : photos) {
        Util.createUploadFile(photo);
      }
    }
    log.info("上传信息： email={}, username={}, headImg={}, photos={}", email, username, headImg.getSize(), photos.length);
    return "redirect:/form_basic";
  }
}
