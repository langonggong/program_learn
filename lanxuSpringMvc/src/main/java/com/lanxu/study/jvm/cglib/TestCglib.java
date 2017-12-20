package com.lanxu.study.jvm.cglib;

import com.lanxu.util.Log4jUtil;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.CallbackFilter;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.InterfaceMaker;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.cglib.proxy.NoOp;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Method;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年12月19 20:07
 * @link http://blog.csdn.net/zghwaicsdn/article/details/50957474
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/mybatis-test.xml"})
public class TestCglib {
  private final Logger logger = Log4jUtil.getLogger(Log4jUtil.LOG_TEST_FILE, TestCglib
      .class);

  //动态代理
  @Test
  public void test() {
    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(TargetObject.class);
    enhancer.setCallback(new TargetInterceptor());
    TargetObject targetObject2 = (TargetObject) enhancer.create();
    logger.debug(targetObject2.toString());
    logger.debug(targetObject2.method1("mmm1"));
    logger.debug(targetObject2.method2(100) + "");
    logger.debug(targetObject2.method3(200) + "");
  }

  //回调过滤器CallbackFilter
  @Test
  public void test2() {
    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(TargetObject.class);
    CallbackFilter callbackFilter = new TargetMethodCallbackFilter();

    /**
     * 根据TargetMethodCallbackFilter的返回值，决定使用cbarray中的第几个进行处理
     *
     * (1)callback1：方法拦截器
     * (2)NoOp.INSTANCE：这个NoOp表示no operator，即什么操作也不做，代理类直接调用被代理的方法不进行拦截。
     * (3)FixedValue：表示锁定方法返回值，无论被代理类的方法返回什么值，回调方法都返回固定值。
     */
    Callback noopCb = NoOp.INSTANCE;
    Callback callback1 = new TargetInterceptor();
    Callback fixedValue = new TargetResultFixed();
    Callback[] cbarray = new Callback[]{callback1, noopCb, fixedValue};
    //enhancer.setCallback(new TargetInterceptor());
    enhancer.setCallbacks(cbarray);
    enhancer.setCallbackFilter(callbackFilter);
    TargetObject targetObject2 = (TargetObject) enhancer.create();
    logger.debug(targetObject2.toString());
    logger.debug(targetObject2.method1("mmm1"));
    logger.debug(targetObject2.method2(100) + "");
    logger.debug(targetObject2.method3(100) + "");
    logger.debug(targetObject2.method3(200) + "");
  }

  //只第一次懒加载
  @Test
  public void lazyLoader() {
    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(PropertyBean.class);
    PropertyBean propertyBean = (PropertyBean) enhancer.create(PropertyBean.class,
        new ConcreteClassLazyLoader());
    logger.debug("get");
    propertyBean.getKey();
    propertyBean.getValue();
  }

  //只第一次懒加载
  @Test
  public void dispatcher() {
    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(PropertyBean.class);
    PropertyBean propertyBean = (PropertyBean) enhancer.create(PropertyBean.class,
        new ConcreteClassDispatcher());
    logger.debug("get");
    propertyBean.getKey();
    propertyBean.getValue();
  }

  //接口生成器
  @Test
  public void InterfaceMaker() throws Exception {
    InterfaceMaker interfaceMaker = new InterfaceMaker();
    //抽取某个类的方法生成接口方法
    interfaceMaker.add(TargetObject.class);
    Class<?> targetInterface = interfaceMaker.create();
    for (Method method : targetInterface.getMethods()) {
      logger.debug(method.getName());
    }
    //接口代理并设置代理接口方法拦截
    Object object = Enhancer.create(Object.class, new Class[]{targetInterface},
        new MethodInterceptor() {
          @Override
          public Object intercept(Object obj, Method method, Object[] args,
                                  MethodProxy methodProxy) throws Throwable {
            if (method.getName().equals("method1")) {
              logger.debug("filter method1 ");
              return "mmmmmmmmm";
            }
            if (method.getName().equals("method2")) {
              logger.debug("filter method2 ");
              return 1111111;
            }
            if (method.getName().equals("method3")) {
              logger.debug("filter method3 ");
              return 3333;
            }
            return "default";
          }
        });
    Method targetMethod1 = object.getClass().getMethod("method3", new Class[]{int.class});
    int i = (int) targetMethod1.invoke(object, new Object[]{33});
    Method targetMethod = object.getClass().getMethod("method1", new Class[]{String.class});
    logger.debug(targetMethod.invoke(object, new Object[]{"sdfs"}).toString());
  }
}