package com.lanxu.study.lambda;

import com.lanxu.study.lambda.actions.Action2;
import com.lanxu.study.lambda.actions.Action3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年12月06 17:24
 **/
@RunWith(JUnit4.class)
public class ActionTest {

  public static String test(int i) {
    return "i=" + i;
  }

  //Functional接口
  @Test
  public void action2Test() {
    Action2<String, Integer> a2 = (f) -> ("this is " + f);
    System.out.println(a2.run(3));
  }

  //使用 :: 关键字来传递方法(静态方法和非静态方法)
  @Test
  public void action3Test() {
    Action3 a = Integer::toBinaryString;
    Action3 b = ActionTest::test;
    System.out.println(a.run(2));
    System.out.println(b.run(3));
  }
}