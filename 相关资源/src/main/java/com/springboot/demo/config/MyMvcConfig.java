package com.springboot.demo.config;

import com.springboot.demo.component.LoginHandleInterceptor;
import com.springboot.demo.component.MyLocaleResolver;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/").setViewName("login");
    // registry.addViewController("/index").setViewName("login");
    // registry.addViewController("/index").setViewName("login");
    registry.addViewController("/main").setViewName("dashboard");
    // registry.addViewController("/emp").setViewName("emp/empForm");
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    // 添加拦截器拦截url的规则
    registry.addInterceptor(new LoginHandleInterceptor()).addPathPatterns("/**").excludePathPatterns("/", "/user/login",
        "/user/logout", "/asserts/**");
  }
  // @Bean //添加到容器中
  // public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
  // WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
  // @Override
  // public void addViewControllers(ViewControllerRegistry registry) {
  // registry.addViewController("/").setViewName("login");
  // registry.addViewController("/index.html").setViewName("login");
  // }
  // };
  // return adapter;
  // }

  @Bean // 添加区域信息控制器到容器中
  public LocaleResolver localeResolver() {
    return new MyLocaleResolver();
  }

}
