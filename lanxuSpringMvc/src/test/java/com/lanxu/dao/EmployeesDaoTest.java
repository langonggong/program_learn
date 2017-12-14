package com.lanxu.dao;

import com.alibaba.fastjson.JSON;
import com.lanxu.domain.Employees;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lanxu on 2017/12/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/mybatis-test.xml"})
public class EmployeesDaoTest {

  @Autowired
  EmployeesDao target;

  @Test
  @Transactional("lanxuTxManager") // 标明此方法需使用事务
  @Rollback(true)
  public void get() throws Exception {
    Employees employees = target.get(10001);
    System.out.println(JSON.toJSONString(employees));
  }

}