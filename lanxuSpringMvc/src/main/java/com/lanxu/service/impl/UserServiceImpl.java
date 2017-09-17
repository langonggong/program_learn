package com.lanxu.service.impl;

import com.lanxu.pojo.User;
import com.lanxu.service.UserService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年09月17 14:47
 **/
@Service
public class UserServiceImpl implements UserService {

  @Cacheable(value = "common", key = "'id_'+#id")
  public User selectByPrimaryKey(Integer id) {
    User user = new User("1001", "lanxu");
    return user;
  }

  @CachePut(value = "common", key = "#user.getUserName()")
  public void insertSelective(User user) {
//		userDao.insertSelective(user);
  }

  @CacheEvict(value = "common", key = "'id_'+#id")
  public void deleteByPrimaryKey(Integer id) {
//		userDao.deleteByPrimaryKey(id);
  }
}