package com.lanxu.study.jvm.cglib;

import com.lanxu.util.Log4jUtil;

import org.slf4j.Logger;
import org.springframework.cglib.proxy.FixedValue;

/**
 * 表示锁定方法返回值，无论被代理类的方法返回什么值，回调方法都返回固定值
 *
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年12月20 17:08
 **/
public class TargetResultFixed implements FixedValue {

  private static Logger logger = Log4jUtil.getLogger(Log4jUtil.LOG_TEST_FILE, TargetResultFixed
      .class);

  /**
   * 该类实现FixedValue接口，同时锁定回调值为999
   * (整型，CallbackFilter中定义的使用FixedValue型回调的方法为getConcreteMethodFixedValue，该方法返回值为整型)。
   */
  @Override
  public Object loadObject() throws Exception {
    logger.debug("锁定结果");
    Object obj = 999;
    return obj;
  }
}