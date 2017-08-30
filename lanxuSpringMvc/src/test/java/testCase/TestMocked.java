package testCase;

import com.lanxu.util.SimpleTool;
import com.lanxu.util.UseSimpleTool;
import mockit.Expectations;
import mockit.Mocked;
import mockit.Verifications;
import mockit.integration.junit4.JMockit;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年08月30 17:36
 **/
@RunWith(JMockit.class)
public class TestMocked {
  @Mocked
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

    System.out.println(simpleTool.fun1("param"));
    System.out.println(simpleTool.fun3("param"));
    System.out.println(new UseSimpleTool().fun1("param"));
    System.out.println(new UseSimpleTool().fun3("param"));

    new Verifications() {
      {
        simpleTool.fun1(anyString);
        times = 2;
      }
    };
  }
}