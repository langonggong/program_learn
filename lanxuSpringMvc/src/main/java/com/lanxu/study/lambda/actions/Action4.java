package com.lanxu.study.lambda.actions;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年12月06 23:34
 **/
public class Action4 {
  private String name;

  public Action4() {

  }

  public Action4(String name) {
    this.name = name;
  }

  public void say() {
    System.out.println("name = " + name);
  }
}
