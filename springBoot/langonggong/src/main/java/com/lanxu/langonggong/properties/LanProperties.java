package com.lanxu.langonggong.properties;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年07月22 16:46
 **/
public class LanProperties {

  @Value("${com.lanxu.title}")
  private String title;

  @Value("${com.lanxu.description}")
  private String description;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}