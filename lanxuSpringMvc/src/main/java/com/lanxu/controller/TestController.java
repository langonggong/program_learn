package com.lanxu.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年07月22 17:22
 **/
@Controller
@RequestMapping("/home")
public class TestController {

  //添加一个日志器
  private static final Logger logger = LoggerFactory.getLogger(TestController.class);

  //映射一个action
  @RequestMapping("/index")
  public String index() {
    //输出日志文件
    logger.info("the first jsp pages");
    return "view";
  }

  @RequestMapping("json")
  @ResponseBody
  public String getString() {
    return "hello spring mvc";
  }
}