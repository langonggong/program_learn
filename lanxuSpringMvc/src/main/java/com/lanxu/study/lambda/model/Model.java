package com.lanxu.study.lambda.model;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年12月06 17:56
 **/
public class Model {
  public void test1() {
    System.out.println("test1");
  }

  public void test2(Model a) {
    System.out.println("test2");
  }

  public int test3() {
    System.out.println("test3");
    return 1;
  }

  public static void test4(Model m) {
    System.out.println("test4");
  }
}