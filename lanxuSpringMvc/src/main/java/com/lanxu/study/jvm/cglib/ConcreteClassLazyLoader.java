package com.lanxu.study.jvm.cglib;

import com.lanxu.util.Log4jUtil;

import org.slf4j.Logger;
import org.springframework.cglib.proxy.LazyLoader;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年12月20 19:57
 **/
public class ConcreteClassLazyLoader implements LazyLoader {

  private static Logger logger = Log4jUtil.getLogger(Log4jUtil.LOG_TEST_FILE,
      ConcreteClassLazyLoader.class);

  /**
   * 对需要延迟加载的对象添加代理，在获取该对象属性时先通过代理类回调方法进行对象初始化。
   * 在不需要加载该对象时，只要不去获取该对象内属性，该对象就不会被初始化了（在CGLib的实现中只要去访问该对象内属性的getter方法，
   * 就会自动触发代理类回调）。
   */
  @Override
  public Object loadObject() throws Exception {
    logger.debug("before lazyLoader...");
    PropertyBean propertyBean = new PropertyBean();
    propertyBean.setKey("zghw");
    propertyBean.setValue(new TargetObject());
    logger.debug("after lazyLoader...");
    return propertyBean;
  }
}