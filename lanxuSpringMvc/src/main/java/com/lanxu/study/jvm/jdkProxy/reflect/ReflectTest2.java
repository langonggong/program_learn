package com.lanxu.study.jvm.jdkProxy.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年12月26 17:26
 **/
public class ReflectTest2 {
  public static void main(String[] args) throws Exception {
    Class<student> clazz = student.class;

    Field f = clazz.getDeclaredField("score");

    //通过getType方法只能获得普通类型
    System.out.println("score的类型是：" + f.getType()); //打印Map

    //1. 获得f的泛型类型
    Type gType = f.getGenericType();

    //2.如果gType是泛型类型对像
    if (gType instanceof ParameterizedType) {
      ParameterizedType pType = (ParameterizedType) gType;
      //获取原始类型
      Type rType = pType.getRawType();
      System.out.println("原始类型是: " + rType);

      //获得泛型类型的泛型参数
      Type[] gArgs = pType.getActualTypeArguments();
      //打印泛型参数
      for (int i = 0; i < gArgs.length; i++) {
        System.out.println("第" + i + "个泛型类型是：" + gArgs[i]);
      }
    } else {
      System.out.println("获取泛型信息失败");
    }
  }
}