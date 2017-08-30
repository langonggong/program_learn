package com.lanxu.service;

import com.lanxu.constant.TestStatus;
import com.lanxu.dao.TestDao;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年08月30 10:53
 **/
public class TestService {
  private TestDao dao;

  public void setDao(TestDao dao) {
    this.dao = dao;
  }

  /**
   * 根据存货量判断货物是否畅销
   *
   * @param group
   * @return
   */
  public TestStatus checkStatus(String group) {
    int count = this.dao.getStoreCount(group);

    if (count <= 0) {
      return TestStatus.UNKOWN;
    } else if (count <= 800) {
      return TestStatus.UNSALABLE;
    } else if (count <= 1000) {
      return TestStatus.NORMAL;
    } else {
      return TestStatus.SELLINGWELL;
    }
  }
}