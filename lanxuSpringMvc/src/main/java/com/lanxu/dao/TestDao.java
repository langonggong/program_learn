package com.lanxu.dao;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年08月30 10:53
 **/
public class TestDao {
  private Map<String, Integer> groupCounts = new HashMap<String, Integer>();

  /**
   * 假数据
   */ {
    this.groupCounts.put("A", 500);
    this.groupCounts.put("B", 1000);
    this.groupCounts.put("C", 1200);
  }

  public int getStoreCount(String group) {
    Integer count = this.groupCounts.get(group);

    return null == count ? -1 : count.intValue();
  }
}