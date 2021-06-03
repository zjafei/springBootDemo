package com.spring.l05_web_admin.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class Login implements HandlerInterceptor {

  //
  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
      throws Exception {
    // TODO Auto-generated method stub
    HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
      ModelAndView modelAndView) throws Exception {
    // TODO Auto-generated method stub
    HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
  }

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handle) throws Exception {
    Object loginUser = request.getSession().getAttribute("loginUser");
    if (loginUser != null) {
      return true;
    } else {
      // request.setAttribute("message", "请先登录");
      request.getSession().setAttribute("message", "请先登录");
      response.sendRedirect("/login");
      // request.getRequestDispatcher("/login").forward(request, response);
      return false;
    }
  }

}
