package com.lanxu.pojo;

import java.io.Serializable;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年09月17 14:44
 **/
public class User implements Serializable {
  
  private static final long serialVersionUID = -6329429797618068853L;


  private String id;
  private String name;

  public User() {
  }

  public User(String id, String name) {
    this.id = id;
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "User [id=" + id + ", name=" + name + "]";
  }
}