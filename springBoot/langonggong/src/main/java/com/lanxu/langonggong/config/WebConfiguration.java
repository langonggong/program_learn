package com.lanxu.langonggong.config;

import com.lanxu.langonggong.filter.DemoFilter;

import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年07月22 16:36
 **/
@Configuration
public class WebConfiguration {

  @Bean
  public RemoteIpFilter remoteIpFilter() {
    return new RemoteIpFilter();
  }

  @Bean
  public FilterRegistrationBean testFilterRegistration() {

    FilterRegistrationBean registration = new FilterRegistrationBean();
    registration.setFilter(new DemoFilter());
    registration.addUrlPatterns("/*");
    registration.addInitParameter("paramName", "paramValue");
    registration.setName("MyFilter");
    registration.setOrder(1);
    return registration;
  }
}