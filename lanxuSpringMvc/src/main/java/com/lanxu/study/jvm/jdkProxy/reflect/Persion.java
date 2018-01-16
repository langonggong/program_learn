package com.lanxu.study.jvm.jdkProxy.reflect;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年12月26 15:09
 **/
public class Persion {
  private String name;
  private int age;

  @Override
  public String toString() {
    return name + " --- " + age;
  }
}