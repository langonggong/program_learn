package com.lanxu.study.jvm.jdkProxy;

/**
 * 该类是所有被代理类的接口类，jdk实现的代理要求被代理类基于统一的接口
 *
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年12月20 23:49
 **/
public interface Service {
  public void add();

  public void update();
}