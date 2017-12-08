package com.lanxu.study.lambda.actions;

/**
 * Created by lanxu on 2017/12/6.
 */
@FunctionalInterface
public interface Action<T> {
  public void run(T t);
}
