package com.springboot.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;

import java.util.Arrays;

import com.springboot.demo.filter.MyFilter;
import com.springboot.demo.servelet.MyServelet;
import com.springboot.demo.listener.MyListener;

@Configuration
public class MyServeConfig {

  // 三大组件
  @Bean
  public ServletRegistrationBean<MyServelet> myServelet() {
    ServletRegistrationBean<MyServelet> registrationBean = new ServletRegistrationBean<MyServelet>(new MyServelet(),
        "/myservelet");
    return registrationBean;
  }

  @Bean
  public FilterRegistrationBean<MyFilter> myFilter() {
    FilterRegistrationBean<MyFilter> registrationBean = new FilterRegistrationBean<MyFilter>();
    registrationBean.setFilter(new MyFilter());
    registrationBean.setUrlPatterns(Arrays.asList("/hello", "/myservelet"));
    return registrationBean;
  }

  @Bean
  public ServletListenerRegistrationBean<MyListener> myListener() {
    ServletListenerRegistrationBean<MyListener> registrationBean = new ServletListenerRegistrationBean<MyListener>(
        new MyListener());
    return registrationBean;
  }

  @Bean
  public WebServerFactoryCustomizer<ConfigurableWebServerFactory> myWebServerFactoryCustomizer() {
    return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {
      @Override
      public void customize(ConfigurableWebServerFactory factory) {
        factory.setPort(8888);
      }
    };
  }
}