package com.springboot.demo;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

  @Autowired
  DataSource dataSource;

  @Test
  void contextLoads() throws SQLException{
    System.out.println("-------------------- data source class --------------------");
    System.out.println(dataSource.getClass());
    System.out.println("-------------------- data source connection -----------------");
    Connection connection = dataSource.getConnection();
    System.out.println(connection);
    connection.close();
  }

}
