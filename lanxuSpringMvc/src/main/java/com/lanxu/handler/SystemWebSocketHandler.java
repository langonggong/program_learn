package com.lanxu.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年09月11 22:46
 **/
public class SystemWebSocketHandler implements WebSocketHandler {

  private Logger log = LoggerFactory.getLogger(SystemWebSocketHandler.class);

  private static final ArrayList<WebSocketSession> users = new ArrayList<WebSocketSession>();

  public void afterConnectionEstablished(WebSocketSession session) throws Exception {
    log.info("ConnectionEstablished");
    log.debug("ConnectionEstablished");
    users.add(session);

    session.sendMessage(new TextMessage("connect"));
    session.sendMessage(new TextMessage("new_msg"));

  }

  public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
    log.info("handleMessage" + message.toString());
    log.debug("handleMessage" + message.toString());
    //sendMessageToUsers();
    session.sendMessage(new TextMessage(new Date() + ""));
  }

  public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
    if (session.isOpen()) {
      session.close();
    }
    users.remove(session);

    log.debug("handleTransportError" + exception.getMessage());
  }

  public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
    users.remove(session);
    log.debug("afterConnectionClosed" + closeStatus.getReason());

  }

  public boolean supportsPartialMessages() {
    return false;
  }

  /**
   * 给所有在线用户发送消息
   *
   * @param message
   */
  public void sendMessageToUsers(TextMessage message) {
    for (WebSocketSession user : users) {
      try {
        if (user.isOpen()) {
          user.sendMessage(message);
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

}