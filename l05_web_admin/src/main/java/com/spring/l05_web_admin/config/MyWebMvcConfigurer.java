package com.spring.l05_web_admin.config;

import com.spring.l05_web_admin.interceptor.LoginInterceptor;
import com.spring.l05_web_admin.interceptor.RedisUriCountInterceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

  /**
   * 只有容器中的组件 spring 才会使用 Autowired 注解 filter: servlet定义的组件 脱离了spring也可以使用
   * interceptor: 是spring的组件 可以使用spring的注解功能 servlet > filter > interceptor >
   * controller
   */
  @Autowired
  RedisUriCountInterceptor redisUriCountInterceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    // 在系统设置中添加拦截器
    registry.addInterceptor(redisUriCountInterceptor).addPathPatterns("/**").excludePathPatterns("/css/**", "/fonts/**",
        "/images/**", "/js/**", "/favicon.ico");
    registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**") // 所有请求都被拦截包括静态资源
        .excludePathPatterns("/login", "/css/**", "/fonts/**", "/images/**", "/js/**", "/favicon.ico"); // 放行的请求
  }

}
