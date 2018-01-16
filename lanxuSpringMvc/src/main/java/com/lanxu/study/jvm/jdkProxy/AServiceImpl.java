package com.lanxu.study.jvm.jdkProxy;

import com.lanxu.util.Log4jUtil;

import org.slf4j.Logger;

/**
 * 被代理类，即目标类target
 *
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年12月24 17:22
 **/
public class AServiceImpl implements Service {

  private final Logger logger = Log4jUtil.getLogger(Log4jUtil.LOG_TEST_FILE,
      AServiceImpl.class);

  @Override
  public void add() {
    logger.debug("AService add");
  }

  @Override
  public void update() {
    logger.debug("AService update");
  }
}