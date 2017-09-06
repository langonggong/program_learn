package com.lanxu.pojo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年09月04 22:14
 * @URL http://www.cnblogs.com/zrtqsk/p/3735273.html
 **/
@Component("person")
@Scope()
public class Person implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {

  private final Log logger = LogFactory.getLog(Person.class);

  @Value("${name:张三}")
  private String name;
  @Value("${address:广州}")
  private String address;
  @Value("${phone:13036115907}")
  private String phone;

  private BeanFactory beanFactory;
  private String beanName;

  public Person() {
    logger.info("调用person的构造器实例化");
  }

  // 通过<bean>的init-method属性指定的初始化方法
  @PostConstruct
  public void myInit() {
    logger.info("[init-metho]调用<bean>的init-method属性指定的初始化方法");
  }

  // 通过<bean>的destroy-method属性指定的初始化方法
  @PreDestroy
  public void myDestory() {
    logger.info("[destroy-metho]调用<bean>的destroy-method属性指定的初始化方法");
  }

  // 这是BeanFactoryAware接口方法
  public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
    logger.info("[BeanFactoryAware]调用BeanFactoryAware.setBeanFactory方法");
    this.beanFactory = beanFactory;
  }

  // 这是BeanNameAware接口方法
  public void setBeanName(String name) {
    logger.info("[BeanNameAware]调用BeanNameAware.setBeanName");
    this.beanName = name;
  }

  // 这是InitializingBean接口方法
  public void afterPropertiesSet() throws Exception {
    logger.info("[InitializingBean]调用InitializingBean.afterPropertiesSet");
  }

  // 这是DiposibleBean接口方法
  public void destroy() throws Exception {
    logger.info("[DisposableBean]调用DisposableBean.destroy");
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    logger.info("注入name属性");
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    logger.info("注入address属性");
    this.address = address;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    logger.info("注入phone属性");
    this.phone = phone;
  }
}