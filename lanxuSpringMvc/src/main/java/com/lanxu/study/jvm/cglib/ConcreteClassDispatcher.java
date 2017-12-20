package com.lanxu.study.jvm.cglib;

import com.lanxu.util.Log4jUtil;

import org.slf4j.Logger;
import org.springframework.cglib.proxy.Dispatcher;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年12月20 19:59
 **/
public class ConcreteClassDispatcher implements Dispatcher {

  private static Logger logger = Log4jUtil.getLogger(Log4jUtil.LOG_TEST_FILE,
      ConcreteClassDispatcher.class);

  @Override
  public Object loadObject() throws Exception {
    logger.debug("before Dispatcher...");
    PropertyBean propertyBean = new PropertyBean();
    propertyBean.setKey("xxx");
    propertyBean.setValue(new TargetObject());
    logger.debug("after Dispatcher...");
    return propertyBean;
  }
}