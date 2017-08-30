package testCase;

import com.lanxu.service.SimpleInterface;
import com.lanxu.service.impl.SimpleInterfaceImpl;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import mockit.integration.junit4.JMockit;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年08月30 18:05
 **/
@RunWith(JMockit.class)
public class TestInterface {
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

    System.out.println(mockInstance.getCityName());
    System.out.println(mockInstance.getAreaName());
    System.out.println(simpleInterface.getCityName());
    System.out.println(simpleInterface.getAreaName());
    SimpleInterfaceImpl simpleInterfaceImpl = new SimpleInterfaceImpl();
    System.out.println(simpleInterfaceImpl.getCityName());
    System.out.println(simpleInterfaceImpl.getAreaName());
  }
}