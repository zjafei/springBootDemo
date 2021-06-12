package com.spring.l05_web_admin.config;

import java.sql.SQLException;
import java.util.Arrays;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyDataSourceConfig {

    @ConfigurationProperties("spring.datasource")
    @Bean
    public DataSource dataSource() throws SQLException {

        DruidDataSource druidDataSource = new DruidDataSource();
        // druidDataSource.setUrl("jdbc:mysql://localhost:3306/mysql?useSSL=false");
        // druidDataSource.setUsername("root");
        // druidDataSource.setPassword("admin");
        druidDataSource.setFilters("wall,stat");
        return druidDataSource;
    }

    @Bean
    public ServletRegistrationBean<StatViewServlet> statViewServlet() {
        StatViewServlet statViewServlet = new StatViewServlet();
        ServletRegistrationBean<StatViewServlet> registrationBean = new ServletRegistrationBean<StatViewServlet>(
                statViewServlet, "/druid/*");
                registrationBean.addInitParameter("loginUsername", "eric");
                registrationBean.addInitParameter("loginPassword", "111111");
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<WebStatFilter> webStatFilter() {

        WebStatFilter webStatFilter = new WebStatFilter();
        FilterRegistrationBean<WebStatFilter> webStatFilterRegistrationBean = new FilterRegistrationBean<WebStatFilter>(
                webStatFilter);
        webStatFilterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        webStatFilterRegistrationBean.addInitParameter("exclusions", "/druid/*,/css/*,/fonts/*,/images/*,/js/*,/favicon.ico");
        return webStatFilterRegistrationBean;
    }
}
