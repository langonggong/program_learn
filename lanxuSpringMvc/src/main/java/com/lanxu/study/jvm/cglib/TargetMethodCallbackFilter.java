package com.lanxu.study.jvm.cglib;

import com.lanxu.util.Log4jUtil;

import org.slf4j.Logger;
import org.springframework.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

/**
 * 回调方法过滤
 *
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年12月20 17:12
 **/
public class TargetMethodCallbackFilter implements CallbackFilter {

  private static Logger logger = Log4jUtil.getLogger(Log4jUtil.LOG_TEST_FILE,
      TargetMethodCallbackFilter
          .class);

  /**
   * 过滤方法
   * 返回的值为数字，代表了Callback数组中的索引位置，要到用的Callback
   */
  @Override
  public int accept(Method method) {
    if (method.getName().equals("method1")) {
      logger.debug("method1,return 1");
      return 1;
    }
    if (method.getName().equals("method2")) {
      logger.debug("method2,return 2");
      return 2;
    }
    if (method.getName().equals("method3")) {
      logger.debug("method3,return 0");
      return 0;
    }
    logger.debug("method " + method.getName() + " ,return 0");
    return 0;
  }
}