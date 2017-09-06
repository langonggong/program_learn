package config;

import com.lanxu.pojo.Person;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Log4jConfigurer;

import java.io.FileNotFoundException;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年09月05 00:28
 **/
public class BeanLifeCycle {

  static {
    try {
      Log4jConfigurer.initLogging("classpath:log/log4j.xml");
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  private static final Log logger = LogFactory.getLog(BeanLifeCycle.class);

  public static void main(String[] args) {
    logger.debug("现在开始初始化容器");

    ApplicationContext factory = new ClassPathXmlApplicationContext("spring/spring-mvc.xml");
    logger.info("容器初始化成功");
    //得到Preson，并使用
    Person person = factory.getBean("person", Person.class);
    logger.info(person);

    logger.info("现在开始关闭容器！");
    ((ClassPathXmlApplicationContext) factory).registerShutdownHook();
  }
}