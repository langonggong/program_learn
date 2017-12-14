package com.lanxu.dao;

import com.lanxu.annotation.DataSourceBase;
import com.lanxu.domain.Employees;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年12月11 18:22
 **/
@DataSourceBase
public interface EmployeesDao {

  String TABLE = " employees ";
  String COL_ALL = " emp_no, birth_date, first_name, last_name, gender, hire_date";

  @Select("select " + COL_ALL + " from " + TABLE + " where emp_no=#{empNo}")
  Employees get(@Param("empNo") long empNo);
}