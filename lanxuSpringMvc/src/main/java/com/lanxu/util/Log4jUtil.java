package com.lanxu.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Log4jConfigurer;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年12月19 20:35
 **/
public class Log4jUtil {

  public static final String LOG_DEV_FILE = "classpath:log/log4j.xml";
  public static final String LOG_TEST_FILE = "classpath:log/log4j-test.xml";

  public static Logger getLogger(String filePath, Class c) {
    try {
      Log4jConfigurer.initLogging(filePath);
    } catch (Exception e) {
      System.out.println("Cannot Initialize log4j");
    }
    return LoggerFactory.getLogger(c);
  }
}