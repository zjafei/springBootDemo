package com.springboot.demo.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {


  @Override
  public void contextInitialized(ServletContextEvent sce) {
    ServletContextListener.super.contextInitialized(sce);
    System.out.println("服务启动了");
  }
  
  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    ServletContextListener.super.contextDestroyed(sce);
    System.out.println("服务销毁了");
  }
}