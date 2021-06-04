package com.spring.l05_web_admin.model;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class Util {
  public static String baseDir = System.getProperty("user.dir");

  public static void createUploadFile(MultipartFile file) throws IllegalStateException, IOException {
    if (!file.isEmpty()) {
      String originalFilename = file.getOriginalFilename();
      file.transferTo(new File(Util.baseDir + File.separator + "upload" + File.separator + originalFilename));
    }
  }
}
