package com.lanxu.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年09月04 23:08
 **/
@Component("beanPostProcessor")
public class MyBeanPostProcessor implements BeanPostProcessor {

  private final Log logger = LogFactory.getLog(MyBeanPostProcessor.class);

  public MyBeanPostProcessor() {
    super();
    logger.info("MyBeanPostProcessor的构造方法");
  }

  public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
    logger.info("BeanPostProcessor接口的postProcessBeforeInitialization方法对属性进行修改");
    logger.info("bean: " + bean + " beanName: " + beanName);
    return bean;
  }

  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    logger.info("BeanPostProcessor接口的postProcessAfterInitialization方法对属性进行修改");
    logger.info("bean: " + bean + " beanName: " + beanName);
    return bean;
  }
}