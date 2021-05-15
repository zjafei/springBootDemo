package com.springboot2.l01_hello_world;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.cache.interceptor.CacheAspectSupport;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class L01HelloWorldApplication {

  public static void main(String[] args) {
    // SpringApplication.run(L01HelloWorldApplication.class, args);
    // 返回容器
    ConfigurableApplicationContext run = SpringApplication.run(L01HelloWorldApplication.class, args);

    // 获取容器组件名
    String[] names = run.getBeanDefinitionNames();
    Integer i = 1;
    System.out.println("----------- Bean definition name ---------------");
    for (String name : names) {
      System.out.print(i);
      System.out.print(": ");
      System.out.println(name);
      i = i + 1;
    }
    System.out.println("----------- end ---------------");

    int beanDefinitionCount = run.getBeanDefinitionCount();
    System.out.println(beanDefinitionCount);

    String[] beanNamesForType = run.getBeanNamesForType(CacheAspectSupport.class);
    System.out.println("======" + beanNamesForType.length);

    // 3、从容器中获取组件

    String[] beanNamesForType1 = run.getBeanNamesForType(WebMvcProperties.class);
    System.out.println("======" + beanNamesForType1.length);
    //
    // Pet tom01 = run.getBean("tom", Pet.class);
    //
    // Pet tom02 = run.getBean("tom", Pet.class);
    //
    // System.out.println("组件："+(tom01 == tom02));
    //
    //
    // //4、com.atguigu.boot.config.MyConfig$$EnhancerBySpringCGLIB$$51f1e1ca@1654a892
    // MyConfig bean = run.getBean(MyConfig.class);
    // System.out.println(bean);
    //
    // //如果@Configuration(proxyBeanMethods =
    // true)代理对象调用方法。SpringBoot总会检查这个组件是否在容器中有。
    // //保持组件单实例
    // User user = bean.user01();
    // User user1 = bean.user01();
    // System.out.println(user == user1);
    //
    //
    // User user01 = run.getBean("user01", User.class);
    // Pet tom = run.getBean("tom", Pet.class);
    //
    // System.out.println("用户的宠物："+(user01.getPet() == tom));
    //
    //
    // //5、获取组件
    // String[] beanNamesForType = run.getBeanNamesForType(User.class);
    // System.out.println("======");
    // for (String s : beanNamesForType) {
    // System.out.println(s);
    // }
    //
    // DBHelper bean1 = run.getBean(DBHelper.class);
    // System.out.println(bean1);

    boolean tom = run.containsBean("tom");
    System.out.println("容器中Tom组件：" + tom);

    boolean user01 = run.containsBean("user01");
    System.out.println("容器中user01组件：" + user01);

    boolean tom22 = run.containsBean("tom22");
    System.out.println("容器中tom22组件：" + tom22);

    boolean haha = run.containsBean("haha");
    boolean hehe = run.containsBean("hehe");
    System.out.println("haha：" + haha);
    System.out.println("hehe：" + hehe);
  }

}
