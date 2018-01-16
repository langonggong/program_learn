package com.lanxu.study.jvm.jdkProxy;

import com.lanxu.util.Log4jUtil;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Proxy;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年12月20 23:56
 * @link http://blog.csdn.net/dreamrealised/article/details/12885739
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/mybatis-test.xml"})
public class TestJdkProxy {

  private final Logger logger = Log4jUtil.getLogger(Log4jUtil.LOG_TEST_FILE,
      TestJdkProxy.class);

  @Test
  public void test() {
    Service aServiceImpl = new AServiceImpl();
    MyInvocationHandler handler = new MyInvocationHandler(aServiceImpl);
    Service aServiceProxy = (Service) Proxy.newProxyInstance(aServiceImpl.getClass()
            .getClassLoader(),
        aServiceImpl.getClass().getInterfaces(), handler);
    aServiceProxy.add();
    aServiceProxy.update();
  }
}