package testCase;

import com.lanxu.pojo.AbstractA;
import com.lanxu.pojo.ClassA;
import com.lanxu.pojo.ClassB;
import com.lanxu.pojo.InterfaceB;
import mockit.*;
import mockit.integration.junit4.JMockit;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.util.Log4jConfigurer;

import java.io.FileNotFoundException;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年08月30 12:10
 * @URL http://www.cnblogs.com/SirSmith/p/5116802.html
 **/
@RunWith(JMockit.class)
public class TotalTest {

  static {
    try {
      Log4jConfigurer.initLogging("classpath:log/log4j.xml");
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  /**
   * mock私有方法
   */
  @Test
  public void testPrivateMethod() {
    final ClassA classA = new ClassA();
    new NonStrictExpectations(classA) {
      {
        Deencapsulation.invoke(classA, "getAnythingPrivate");
        result = 100;
        times = 1;
      }
    };
    Assert.assertEquals(100, classA.getAnything());
    new Verifications() {
      {
        Deencapsulation.invoke(classA, "getAnythingPrivate");
        times = 1;
      }
    };
  }

  /**
   * mock私有静态方法
   */
  @Test
  public void testPrivateStaticMethod() {

    new NonStrictExpectations(ClassA.class) {
      {
        Deencapsulation
            .invoke(ClassA.class, "getStaticAnythingPrivate");
        result = 100;
        times = 1;
      }
    };

    Assert.assertEquals(100, ClassA.getStaticAnything());

    new Verifications() {
      {
        Deencapsulation
            .invoke(ClassA.class, "getStaticAnythingPrivate");
        times = 1;
      }
    };

  }

  /**
   * mock公有方法
   */
  @Test
  public void testPublicMethod() {
    final ClassA classA = new ClassA();
    new NonStrictExpectations(classA) {
      {
        classA.getAnything();
        result = 100;
        times = 1;
      }
    };

    Assert.assertEquals(100, classA.getAnything());

    new Verifications() {
      {
        classA.getAnything();
        times = 1;
      }
    };
  }

  /**
   * mock公有静态方法--基于行为
   */
  @Test
  public void testPublicStaticMethod() {

    new NonStrictExpectations(ClassA.class) {
      {
        ClassA.getStaticAnything();
        result = 100;
        times = 1;
      }
    };

    Assert.assertEquals(100, ClassA.getStaticAnything());

    new Verifications() {
      {
        ClassA.getStaticAnything();
        times = 1;
      }
    };
  }

  /**
   * mock公有静态方法--基于状态
   */
  @Test
  public void testPublicStaticMethodBaseOnStatus() {

    MockUp<ClassA> mockUp = new MockUp<ClassA>() {
      @Mock
      public int getStaticAnything() { //注意这里不用声明为static
        return 100;
      }
    };

    Assert.assertEquals(100, ClassA.getStaticAnything());
  }

  /**
   * mock接口
   */
  @Test
  public void testInterface() {
/*    InterfaceB interfaceB = new InterfaceB() {
      public int getAnything() {
        return 100;
      }
    };*/
    InterfaceB interfaceB = new MockUp<InterfaceB>() {
      @Mock
      public int getAnything() {
        return 100;
      }
    }.getMockInstance();
    ClassA classA = new ClassA();
    classA.setInterfaceB(interfaceB);
    Assert.assertEquals(100, classA.getClassBAnything());
  }

  /**
   * mock接口--基于状态
   */
  @Test
  public void testInterfaceBasedOnStatus() {
    final InterfaceB interfaceB = new ClassB();

    new NonStrictExpectations(interfaceB) {
      {
        interfaceB.getAnything();
        result = 100;
        times = 1;
      }
    };

    ClassA classA = new ClassA();
    classA.setInterfaceB(interfaceB);

    Assert.assertEquals(100, classA.getClassBAnything());

    new Verifications() {
      {
        interfaceB.getAnything();
        times = 1;
      }
    };
  }

  /**
   * mock抽象类
   */
  @Test
  public void testAbstract() {
    AbstractA abstractA = new MockUp<AbstractA>() {
      @Mock
      public int getAbstractAnything() {
        return 100;
      }

      @Mock
      public int getAnything() {
        return 1000;
      }
    }.getMockInstance();

    Assert.assertEquals(100, abstractA.getAbstractAnything());

    Assert.assertEquals(1000, abstractA.getAnything());
  }

  /**
   * 设置私有属性
   */
  @Test
  public void testMockPrivateProperty() {
    final ClassA classA = new ClassA();
    new NonStrictExpectations(classA) {
      {
        Deencapsulation.setField(classA, "number", 666);
      }
    };
    Assert.assertEquals(666, classA.getNumber());
  }

  /**
   * 设置静态私有属性
   */
  @Test
  public void testMockPrivateStaticProperty() {
    new NonStrictExpectations(ClassA.class) {
      {
        Deencapsulation.setField(ClassA.class, "str", "str has been changed!");
      }
    };
    Assert.assertEquals("str has been changed!", ClassA.getStr());
  }
}