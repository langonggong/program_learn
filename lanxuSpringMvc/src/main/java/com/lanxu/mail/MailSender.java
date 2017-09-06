package com.lanxu.mail;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年08月30 00:19
 **/
public class MailSender {

  private final Log logger = LogFactory.getLog(MailSender.class);


  public boolean send() {
    return true;
  }

  public boolean doSend(String mail) {
    logger.info("send " + mail);
    return true;
  }
}