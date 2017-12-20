package com.lanxu.dao;

import com.alibaba.fastjson.JSON;
import com.lanxu.domain.Employees;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * Created by lanxu on 2017/12/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/mybatis-test.xml"})
public class EmployeesDaoTest {

  private final Log logger = LogFactory.getLog(EmployeesDaoTest.class);

  @Autowired
  EmployeesDao target;

  @Test
  @Transactional("lanxuTxManager") // 标明此方法需使用事务
  @Rollback(true)
  public void get() throws Exception {
    Employees employees = target.get(10001);
    System.out.println(JSON.toJSONString(employees));
  }

  @Test
  @Transactional("lanxuTxManager") // 标明此方法需使用事务
  @Rollback(true)
  public void getEmployeess() throws Exception {
    List<Long> empNos = Arrays.asList(10001l, 10002l, 10003l);
    List<Employees> employees = target.getEmployeess(empNos);
    logger.info(JSON.toJSON(employees));
  }

}