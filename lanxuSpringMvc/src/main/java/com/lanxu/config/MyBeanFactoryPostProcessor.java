package com.lanxu.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年09月04 23:22
 **/
@Component("beanFactoryPostProcessor")
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

  private final Log logger = LogFactory.getLog(MyBeanFactoryPostProcessor.class);

  public MyBeanFactoryPostProcessor() {
    super();
    logger.info("MyBeanFactoryPostProcessor构造函数");
  }

  public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
    logger.info("BeanFactoryPostProcessor调用postProcessBeanFactory");
    BeanDefinition beanDefinition = beanFactory.getBeanDefinition("person");
    beanDefinition.getPropertyValues().addPropertyValue("phone", 110);
  }
}