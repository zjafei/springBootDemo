package com.spring.l05_web_admin.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class RedisUriCount implements HandlerInterceptor {

  @Autowired
  StringRedisTemplate redisTemplate;

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handle) throws Exception {
    String uri = request.getRequestURI();

    // 每次访问就加1
    redisTemplate.opsForValue().increment(uri);
    return true;
  }

}
