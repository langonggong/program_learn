package testCase;

import com.lanxu.util.SimpleTool;
import com.lanxu.util.UseSimpleTool;
import mockit.Delegate;
import mockit.Expectations;
import mockit.Mocked;
import mockit.Verifications;
import mockit.integration.junit4.JMockit;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年08月30 18:00
 **/
@RunWith(JMockit.class)
public class TestDelegate {
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

    System.out.println(simpleTool.fun1("param0"));
    System.out.println(simpleTool.fun3("param"));
    System.out.println(new UseSimpleTool().fun1("param1"));

    new Verifications() {
      {
        simpleTool.fun1(anyString);
        times = 2;
      }
    };
  }
}