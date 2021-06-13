package com.spring.l05_web_admin.model;

import com.alibaba.druid.sql.dialect.oracle.ast.clause.OracleStorageClause.FlashCacheType;
import com.baomidou.mybatisplus.annotation.TableField;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
  public User(String username, String password, String auth) {
    this.username = username;
    this.password = password;
    this.auth = auth;
  }

  @TableField(exist = false)
  private String username;

  @TableField(exist = false)
  private String password;

  @TableField(exist = false)
  private String auth;

  // 以下是数据库字段
  private Long id;
  private String name;
  private Integer age;
  private String email;
}
