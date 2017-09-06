package com.lanxu.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.stereotype.Component;

import java.beans.PropertyDescriptor;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年09月04 23:12
 **/
@Component("instantiationAwareBeanPostProcessor")
public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {

  private final Log logger = LogFactory.getLog(MyInstantiationAwareBeanPostProcessor.class);

  public MyInstantiationAwareBeanPostProcessor() {
    logger.info("这是MyInstantiationAwareBeanPostProcessor的构造器");
  }

  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
    logger.info("InstantiationAwareBeanPostProcessorAdapter调用postProcessBeforeInitialization方法");
    return super.postProcessBeforeInitialization(bean, beanName);
  }

  @Override
  public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
    logger.info("InstantiationAwareBeanPostProcessorAdapter调用postProcessAfterInstantiation方法");
    return super.postProcessAfterInstantiation(bean, beanName);
  }

  @Override
  public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
    logger.info("InstantiationAwareBeanPostProcessorAdapter调用postProcessPropertyValues方法");
    return super.postProcessPropertyValues(pvs, pds, bean, beanName);
  }
}