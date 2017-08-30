package testCase;

import com.lanxu.constant.TestStatus;
import com.lanxu.dao.TestDao;
import com.lanxu.service.TestService;
import mockit.Mocked;
import mockit.NonStrictExpectations;
import mockit.Verifications;
import mockit.integration.junit4.JMockit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年08月30 11:04
 **/
@RunWith(JMockit.class)
public class ServiceBehavier {

  @Mocked
  TestDao dao;

  private TestService service;

  @Before
  public void init() {
    service = new TestService();
  }

  @Test
  public void test() {
    // 1. record 录制期望值
    new NonStrictExpectations() {
      {
        /**
         * 录制的方法
         */
        dao.getStoreCount(anyString);
        /**
         * 预期结果，返回900
         */
        result = 900;
        /**
         * times必须调用两次。在Expectations中，必须调用，否则会报错，因此不需要作校验。
         * 在NonStrictExpectations中不强制要求，但要进行verify验证.但似乎已经强制要求了
         * 此外还有maxTimes，minTimes
         */
        times = 1;
      }
    };
    service.setDao(dao);
    // 2. replay 调用
    Assert.assertEquals(TestStatus.NORMAL, service.checkStatus("D"));
    //3.校验是否只调用了一次。如果上面注释的语句再调一次，且把录制的times改为2，那么在验证阶段将会报错。
    new Verifications() {
      {
        dao.getStoreCount(anyString);
        times = 1;
      }
    };
  }
}