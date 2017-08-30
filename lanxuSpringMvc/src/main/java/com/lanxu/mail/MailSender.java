package com.lanxu.mail;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年08月30 00:19
 **/
public class MailSender {

  public boolean send() {
    return true;
  }

  public boolean doSend(String mail) {
    System.out.println("send " + mail);
    return true;
  }
}