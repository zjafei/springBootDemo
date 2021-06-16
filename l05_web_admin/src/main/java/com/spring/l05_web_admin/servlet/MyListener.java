package com.spring.l05_web_admin.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebListener
public class MyListener implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // ServletContextListener.super.contextDestroyed(sce);
        log.info("监听器销毁了");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // ServletContextListener.super.contextInitialized(sce);
        log.info("监听器初始化");
    }
    
}
