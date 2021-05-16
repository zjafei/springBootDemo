package com.spring.boot.boot_01_helloworld_2.bean;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@ConfigurationProperties(prefix = "person")//与配置文件绑定
@Component
@Data
public class Person {
  private String userName;
  private Boolean boss;
  private Date birth;
  private Integer age;
  private Pet pet;
  private String[] interests;
  private List<String> animal;
  private Map<String, Object> score;
  private Set<Double> salaryList;
  private Map<String, List<Pet>> allPets;
}
