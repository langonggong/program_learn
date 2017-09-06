package testCase;

import com.lanxu.util.SimpleTool;
import com.lanxu.util.UseSimpleTool;
import mockit.Expectations;
import mockit.Injectable;
import mockit.Verifications;
import mockit.integration.junit4.JMockit;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年08月30 17:40
 **/
@RunWith(JMockit.class)
public class TestInjectable {

  private final Log logger = LogFactory.getLog(TestInjectable.class);

  @Injectable
  SimpleTool simpleTool;

  @Test
  public void testExpectation() {

    //未mock函数返回null
    new Expectations() {
      {
        simpleTool.fun1(anyString);
        result = "MOCK";
      }
    };

    logger.info(simpleTool.fun1("param"));
    logger.info(simpleTool.fun3("param"));
    logger.info(new UseSimpleTool().fun1("param"));
    logger.info(new UseSimpleTool().fun3("param"));

    new Verifications() {
      {
        simpleTool.fun1(anyString);
        times = 1;
      }
    };
  }

}