package com.lanxu.network;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年09月12 23:14
 * @url http://www.cnblogs.com/best/archive/2016/09/12/5695570.html
 **/
//@ServerEndpoint("/push")
public class EchoEndpoint {

  private Logger log = LoggerFactory.getLogger(ServerEndpoint.class);

  @OnOpen
  public void onOpen(Session session) throws IOException {
    log.info("onOpen");
  }

  @OnMessage
  public String onMessage(String message) {
    log.info("onMessage");
    return "onMessage";
  }

  @OnMessage(maxMessageSize = 6)
  public void receiveMessage(String s) {
    log.info("receiveMessage param:" + s);
  }

  @OnError
  public void onError(Throwable t) {
    log.info("onError :" + t.getMessage());
  }

  @OnClose
  public void onClose(Session session, CloseReason reason) {
    log.info("onClose");
  }

}