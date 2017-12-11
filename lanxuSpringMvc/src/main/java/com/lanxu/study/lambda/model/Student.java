package com.lanxu.study.lambda.model;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年12月06 23:55
 **/
public class Student {
  private String name;

  public Student(String name) {
    System.out.println("create a student");
    this.name = name;
  }

  public String getName() {
    return name;
  }

}