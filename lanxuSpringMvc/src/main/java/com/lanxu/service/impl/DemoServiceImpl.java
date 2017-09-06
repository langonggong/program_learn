package com.lanxu.service.impl;

import com.lanxu.service.DemoService;
import org.springframework.stereotype.Service;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年08月30 18:27
 **/
@Service
public class DemoServiceImpl implements DemoService {
  public String getName(String name) {
    return "hello " + name;
  }
}