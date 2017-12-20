package com.lanxu.study.jvm.cglib;

/**
 * 没有实现接口，需要CGlib动态代理的目标类
 *
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年12月19 19:58
 **/
public class TargetObject {

  public String method1(String paramName) {
    return paramName;
  }

  public int method2(int count) {
    return count;
  }

  public int method3(int count) {
    return count;
  }

  @Override
  public String toString() {
    return "目标对象:" + getClass();
  }
}