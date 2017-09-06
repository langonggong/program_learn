package com.lanxu.controller;

import com.lanxu.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年08月30 18:28
 **/
@Controller
@RequestMapping(value = "demo")
public class DemoController {

  @Autowired
  DemoService demoService;

  @RequestMapping(value = "test", method = RequestMethod.GET)
  @ResponseBody
  public String getName(@RequestParam("name") String name) {
    return demoService.getName(name);
  }
}