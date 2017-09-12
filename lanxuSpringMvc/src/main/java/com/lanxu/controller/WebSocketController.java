package com.lanxu.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年09月11 23:51
 * @url http://blog.csdn.net/linlzk/article/details/51086545
 **/
@Controller
public class WebSocketController {

  //添加一个日志器
  private final Logger logger = LoggerFactory.getLogger(WebSocketController.class);

  @RequestMapping("/websocket")
  public String index() {
    //输出日志文件
    logger.info("websocket page");
    return "websocket";
  }

  @RequestMapping("/mspjapi/webSocketServer/sockjs/info")
  @ResponseBody
  public String sendMsg(HttpServletResponse response) {
    String str = "{\"name\":\"fuck\",\"age\":18}";
    logger.info(str);
    response.setHeader("Access-Control-Allow-Origin", "*");
    return str;
  }

}