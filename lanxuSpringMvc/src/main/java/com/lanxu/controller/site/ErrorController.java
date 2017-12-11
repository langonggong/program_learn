package com.lanxu.controller.site;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年12月08 18:04
 **/
@Controller
@RequestMapping("error")
public class ErrorController {

  @RequestMapping("{page}")
  public String error(@PathVariable("page") String page) {
    return page;
  }
}