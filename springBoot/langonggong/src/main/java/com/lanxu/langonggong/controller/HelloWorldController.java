package com.lanxu.langonggong.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年07月22 11:49
 **/
@RestController
public class HelloWorldController {
  @RequestMapping("/hello")
  public String index() {
    return "Hello World";

  }
}