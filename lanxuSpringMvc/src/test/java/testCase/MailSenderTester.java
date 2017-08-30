package testCase;

import com.lanxu.mail.MailSender;
import mockit.integration.junit4.JMockit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年08月30 00:22
 **/
@RunWith(JMockit.class)
public class MailSenderTester {

  MailSender mailSender;

  @Before
  public final void init() {
    mailSender = new MailSender();
  }

  @Test
  public void sendTest() {
    boolean isSuccess = mailSender.send();
    Assert.assertEquals(true, isSuccess);
  }

}