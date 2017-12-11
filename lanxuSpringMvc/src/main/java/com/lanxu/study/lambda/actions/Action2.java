package com.lanxu.study.lambda.actions;

/**
 * Created by lanxu on 2017/12/6.
 */
@FunctionalInterface
public interface Action2<T, F> {
  T run(F f);
}
