package testCase;

import com.lanxu.constant.TestStatus;
import com.lanxu.dao.TestDao;
import com.lanxu.service.TestService;
import mockit.Mock;
import mockit.MockUp;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年08月30 11:24
 **/
public class ServiceState {

  private TestDao dao;
  private TestService service;

  @Test
  public void test() {
    //1. mock对象
    MockUp<TestDao> mockUp = new MockUp<TestDao>() {
      @Mock
      public int getStoreCount(String group) {
        return 2000;
      }
    };
    //2. 获取实例
    dao = mockUp.getMockInstance();
    service = new TestService();
    service.setDao(dao);
    //3.调用
    Assert.assertEquals(TestStatus.SELLINGWELL, service.checkStatus("HHHHH"));
    //4. 还原对象，避免测试方法之间互相影响。其实对一个实例来说没什么影响，对静态方法影响较大。旧版本的tearDown()方法是Mockit类的静态方法
    mockUp.tearDown();
  }

}