package com.lanxu.pojo;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年08月30 12:08
 **/
public class ClassA {
  InterfaceB interfaceB;

  private int number;

  private static String str;

  public void setInterfaceB(InterfaceB interfaceB) {
    this.interfaceB = interfaceB;
  }

  public int getAnything() {
    return getAnythingPrivate();
  }

  private int getAnythingPrivate() {
    return 1;
  }

  public int getNumber() {
    return number;
  }


  public static int getStaticAnything() {
    return getStaticAnythingPrivate();
  }

  private static int getStaticAnythingPrivate() {
    return 1;
  }

  public int getClassBAnything() {
    return this.interfaceB.getAnything();
  }

  public static String getStr() {
    return str;
  }
}