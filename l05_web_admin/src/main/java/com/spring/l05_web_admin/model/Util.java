package com.spring.l05_web_admin.model;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public class Util {

  public static String baseDir = System.getProperty("user.dir");

  public static Map<String, Object> resultWarp() {
    Map<String, Object> map = new HashMap<String, Object>();
    return map;
  }


  public static ResultWarp createUploadFile(MultipartFile file) throws IllegalStateException, IOException {
    ResultWarp result = new ResultWarp(400, "文件上传失败", null);
    if (!file.isEmpty()) {
      String originalFilename = file.getOriginalFilename();
      System.out.println(originalFilename);
      String filePath = Util.baseDir + File.separator + "upload" + File.separator + originalFilename;
      file.transferTo(new File(filePath));
      result.setMessage("文件上传成功");
      result.setCode(200);
      Map<String, Object> fileMap = new HashMap<>();
      fileMap.put("path", filePath);
      result.setResult(fileMap);
    }
    return result;
  }
}
