package testCase;

import com.lanxu.controller.DemoController;
import com.lanxu.service.DemoService;
import mockit.Injectable;
import mockit.StrictExpectations;
import mockit.Tested;
import mockit.integration.junit4.JMockit;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年08月30 18:34
 **/
@RunWith(JMockit.class)
public class TestDemoController {

  @Tested
  DemoController demoController;

  @Injectable
  DemoService demoService;

  @Test
  public void test() {
    new StrictExpectations() {
      {
        demoService.getName(anyString);
        result = "lanxu(mocked)";
      }
    };
    String str = demoController.getName("youyou");
    Assert.assertEquals("lanxu(mocked)", str);
  }
}