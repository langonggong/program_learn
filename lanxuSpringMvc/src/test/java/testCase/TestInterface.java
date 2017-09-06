package testCase;

import com.lanxu.service.SimpleInterface;
import com.lanxu.service.impl.SimpleInterfaceImpl;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import mockit.integration.junit4.JMockit;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年08月30 18:05
 **/
@RunWith(JMockit.class)
public class TestInterface {

  private final Log logger = LogFactory.getLog(TestInterface.class);

  @Mocked
  SimpleInterface simpleInterface;

  @Test
  public void testUpper() throws Exception {
    SimpleInterface mockInstance = new MockUp<SimpleInterface>() {
      @Mock
      public String getCityName() {
        return "BEIJING(MOCK)";
      }

      @Mock
      public String getAreaName() {
        return "HUABEI(MOCK)";
      }

    }.getMockInstance();

    logger.info(mockInstance.getCityName());
    logger.info(mockInstance.getAreaName());
    logger.info(simpleInterface.getCityName());
    logger.info(simpleInterface.getAreaName());
    SimpleInterfaceImpl simpleInterfaceImpl = new SimpleInterfaceImpl();
    logger.info(simpleInterfaceImpl.getCityName());
    logger.info(simpleInterfaceImpl.getAreaName());
  }
}