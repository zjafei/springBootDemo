package com.spring.l05_web_admin.config;

// import java.util.Arrays;

// import com.spring.l05_web_admin.servlet.MyFilter;
import com.spring.l05_web_admin.servlet.MyServlet;

// import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRegistConfig {
    @Bean
    public ServletRegistrationBean <MyServlet>myServlerRegistrationBean() {
        return new ServletRegistrationBean<MyServlet>(new MyServlet(), "/my_servlet", "/my");
    }

    // @Bean
    // public FilterRegistrationBean myFilterRegistrationBean() {

    //     // return new FilterRegistrationBean<MyFilter>(new MyFilter(),
    //     // this.myServlerRegistrationBean());
    //     FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean<MyFilter>(new MyFilter());
    //     filterRegistrationBean.setUrlPatterns(Arrays.asList("/css/*", "/images/*"));
    //     return filterRegistrationBean;
    // }
}
