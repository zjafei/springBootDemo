package com.spring.l05_web_admin.model;

import java.util.Map;

public class ResultWarp {
  private Integer code;
  private String message;
  private Map<String, Object> result;
  // private Boolean success;
  private Integer timestamp;
  
  public ResultWarp(Integer code, String message, Map<String, Object> result) {
    this.code = code;
    this.message = message;
    this.result = result;
    this.timestamp =  (int)System.currentTimeMillis();
  }

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Map<String, Object> getResult() {
    return result;
  }

  public void setResult(Map<String, Object> result) {
    this.result = result;
  }

  public Integer getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Integer timestamp) {
    this.timestamp = timestamp;
  }

}
