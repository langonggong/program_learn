package com.lanxu.dao;

import com.lanxu.pojo.User;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年09月17 14:45
 **/
public interface UserDao {
  public User selectByPrimaryKey(Integer id);

  public void insertSelective(User user);

  public void deleteByPrimaryKey(Integer id);


}