package com.lanxu.util;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年08月30 17:35
 * @URL https://yq.aliyun.com/articles/47245
 **/
public class SimpleTool {
  public String fun1(String str) {
    return "real: public String fun1(" + str + ")";
  }

  private String fun2(String str) {
    return "real: private String fun2(" + str + ")";
  }

  public String fun3(String str) {
    return "real: public String fun3(" + str + ")";
  }

  public String fun4(String str) {
    return fun2(str);
  }
}