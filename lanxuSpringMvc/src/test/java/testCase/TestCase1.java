package testCase;

import mockit.Expectations;
import mockit.Mocked;
import mockit.integration.junit4.JMockit;
import model.TestObj;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年08月29 23:08
 **/
@RunWith(JMockit.class)
public class TestCase1 {

  @Mocked
  TestObj testObj;

  @Test
  public void testHello() {
    new Expectations() {
      {
        testObj.sayHello("lanxu");
        result = "hello lanxu";
      }
    };
    Assert.assertEquals("hello lanxu", testObj.sayHello("lanxu"));
  }
}