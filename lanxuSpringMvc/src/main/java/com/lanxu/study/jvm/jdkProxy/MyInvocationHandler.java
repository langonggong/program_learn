package com.lanxu.study.jvm.jdkProxy;

import com.lanxu.util.Log4jUtil;

import org.slf4j.Logger;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 实现动态代理类
 *
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年12月20 23:52
 **/
public class MyInvocationHandler implements InvocationHandler {

  private final Logger logger = Log4jUtil.getLogger(Log4jUtil.LOG_TEST_FILE,
      MyInvocationHandler.class);

  private Object target;

  public MyInvocationHandler(Object target) {
    super();
    this.target = target;
  }

  public MyInvocationHandler() {
    super();
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    logger.debug("before-->");
    Object result = method.invoke(target, args);
    logger.debug("-->end");
    return result;
  }
}