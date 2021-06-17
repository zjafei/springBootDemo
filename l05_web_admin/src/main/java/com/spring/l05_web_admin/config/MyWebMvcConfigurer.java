package com.spring.l05_web_admin.config;

import com.spring.l05_web_admin.interceptor.Login;
import com.spring.l05_web_admin.interceptor.RedisUriCount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {
  @Autowired
  RedisUriCount redisUriCount;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    // 在系统设置中添加拦截器
    registry.addInterceptor(redisUriCount).addPathPatterns("/**").excludePathPatterns("/css/**", "/fonts/**",
        "/images/**", "/js/**", "/favicon.ico");
    registry.addInterceptor(new Login()).addPathPatterns("/**") // 所有请求都被拦截包括静态资源
        .excludePathPatterns("/login", "/css/**", "/fonts/**", "/images/**", "/js/**", "/favicon.ico"); // 放行的请求
  }

}
