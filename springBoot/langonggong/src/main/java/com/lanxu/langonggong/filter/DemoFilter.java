package com.lanxu.langonggong.filter;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年07月22 16:37
 **/
public class DemoFilter implements Filter{

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest httpServletRequest= (HttpServletRequest) request;
    System.out.println("this is MyFilter,url :"+httpServletRequest.getRequestURI());
    chain.doFilter(request, response);
  }

  @Override
  public void destroy() {

  }
}