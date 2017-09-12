package com.lanxu.network;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年09月12 23:20
 **/
@ServerEndpoint("/ws/{user}")
public class WSServer {
  private String currentUser;

  //连接打开时执行
  @OnOpen
  public void onOpen(@PathParam("user") String user, Session session) {
    currentUser = user;
    System.out.println("Connected ... " + session.getId());
  }

  //收到消息时执行
  @OnMessage
  public String onMessage(String message, Session session) {
    System.out.println(currentUser + "：" + message);
    return currentUser + "：" + message;
  }

  //连接关闭时执行
  @OnClose
  public void onClose(Session session, CloseReason closeReason) {
    System.out.println(String.format("Session %s closed because of %s", session.getId(), closeReason));
  }

  //连接错误时执行
  @OnError
  public void onError(Throwable t) {
    t.printStackTrace();
  }
}