package com.lanxu.study.jvm.cglib;

import com.lanxu.util.Log4jUtil;

import org.slf4j.Logger;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 目标对象拦截器，实现MethodInterceptor
 *
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年12月19 19:58
 **/
public class TargetInterceptor implements MethodInterceptor {

  private static Logger logger = Log4jUtil.getLogger(Log4jUtil.LOG_TEST_FILE, TargetInterceptor
      .class);

  /**
   * 重写方法拦截在方法前和方法后加入业务
   * Object obj为目标对象
   * Method method为目标方法
   * Object[] params 为参数，
   * MethodProxy proxy CGlib方法代理对象
   */
  @Override
  public Object intercept(Object o, Method method, Object[] params, MethodProxy methodProxy)
      throws Throwable {
    logger.debug("调用前");
    Object result = methodProxy.invokeSuper(o, params);
    logger.debug("调用后: " + result);
    return result;
  }
}