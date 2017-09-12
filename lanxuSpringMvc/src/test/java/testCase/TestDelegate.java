package testCase;

import com.lanxu.util.SimpleTool;
import com.lanxu.util.UseSimpleTool;
import mockit.Delegate;
import mockit.Expectations;
import mockit.Mocked;
import mockit.Verifications;
import mockit.integration.junit4.JMockit;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年08月30 18:00
 **/
@RunWith(JMockit.class)
public class TestDelegate {

  private final Log logger = LogFactory.getLog(TestDelegate.class);

  @Mocked
  SimpleTool simpleTool;

  @Test
  public void testExpectation() {

    new Expectations() {
      {
        simpleTool.fun1(anyString);
        result = new Delegate<String>() {
          public String aDelegateMethod(String str) {
            return str.equals("param0") ? "MOCK0" : "MOCK1";
          }
        };
      }
    };

    logger.info(simpleTool.fun1("param0"));
    logger.info(simpleTool.fun3("param"));
    logger.info(new UseSimpleTool().fun1("param1"));

    new Verifications() {
      {
        simpleTool.fun1(anyString);
        times = 2;
      }
    };
  }
}