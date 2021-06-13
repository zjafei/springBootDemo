package com.spring.l05_web_admin;

// import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

// @MapperScan("com.spring.l05_web_admin.mapper")
@ServletComponentScan(basePackages = "com.spring.l05_web_admin")
@SpringBootApplication
public class L05WebAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(L05WebAdminApplication.class, args);
	}

}
