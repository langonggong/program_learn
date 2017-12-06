package com.lanxu.study.lambda;

/**
 * Created by lanxu on 2017/12/6.
 */
public interface Formula {

  double caculate(int a);

  default double sqrt(int a) {
    return Math.sqrt(a);
  }
}
