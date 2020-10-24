package com.springboot.demo;

import com.springboot.demo.bean.Person;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    Person person;

    @Test
    void contextLoads() {
        System.out.println(person);
        // error > warn > info >　debug > trace
        logger.error("显示 error");
        logger.warn("显示 warn");
        logger.info("显示 info");
        // springboot 默认是 root 从 info 开始显示
        logger.debug("显示 debug");
        logger.trace("显示 trace");
    }
}
