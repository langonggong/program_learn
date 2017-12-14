package com.lanxu.domain;

import java.util.Date;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年12月11 18:07
 **/
public class Employees {

  private long empNo;
  private Date birthDate;
  private String firstName;
  private String lastName;
  private String gender;
  private Date hireDate;


  public long getEmpNo() {
    return empNo;
  }

  public void setEmpNo(long empNo) {
    this.empNo = empNo;
  }

  public Date getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public Date getHireDate() {
    return hireDate;
  }

  public void setHireDate(Date hireDate) {
    this.hireDate = hireDate;
  }

  @Override
  public String toString() {
    return "Employees{" +
        "empNo=" + empNo +
        ", birthDate=" + birthDate +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", gender=" + gender +
        ", hireDate=" + hireDate +
        '}';
  }
}