package com.lanxu.study.jvm.jdkProxy.reflect;

import java.lang.reflect.Field;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年12月26 15:09
 **/
public class ReflectTest {
  public static void setProperty(Object obj, String propertyName, Object value)
      throws Exception {

    //获得类的class文件对像
    Class clazz = obj.getClass();

    //获得propertyName字段
    Field field = clazz.getDeclaredField(propertyName);
    //设置访问权限
    field.setAccessible(true);
    //给obj对像赋值
    field.set(obj, value);
  }

  public static void main(String[] args) throws Exception {
    Persion p = new Persion();
    System.out.println(p);

    setProperty(p, "name", "刘德华");
    setProperty(p, "age", 50);

    System.out.println(p);
  }
}