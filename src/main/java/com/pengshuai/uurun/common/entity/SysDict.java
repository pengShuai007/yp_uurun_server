package com.pengshuai.uurun.common.entity;

import java.util.Date;

public class SysDict {
  private Long id;
  private String dict_category;
  private String dict_code;
  private String dict_key;
  private String dict_value;
  private String parent_key;
  private Date create_time;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDict_category() {
    return dict_category;
  }

  public void setDict_category(String dict_category) {
    this.dict_category = dict_category;
  }

  public String getDict_code() {
    return dict_code;
  }

  public void setDict_code(String dict_code) {
    this.dict_code = dict_code;
  }

  public String getDict_key() {
    return dict_key;
  }

  public void setDict_key(String dict_key) {
    this.dict_key = dict_key;
  }

  public String getDict_value() {
    return dict_value;
  }

  public void setDict_value(String dict_value) {
    this.dict_value = dict_value;
  }

  public String getParent_key() {
    return parent_key;
  }

  public void setParent_key(String parent_key) {
    this.parent_key = parent_key;
  }

  public Date getCreate_time() {
    return create_time;
  }

  public void setCreate_time(Date create_time) {
    this.create_time = create_time;
  }
}
