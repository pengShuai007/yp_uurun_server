package com.pengshuai.uurun.common.entity;

import java.util.Date;

public class SysParameter {
  private Integer id;
  private String param_category;
  private String param_name;
  private String param_value;
  private String subjects;
  private String comments;
  private String description;
  private Date create_time;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getParam_category() {
    return param_category;
  }

  public void setParam_category(String param_category) {
    this.param_category = param_category;
  }

  public String getParam_name() {
    return param_name;
  }

  public void setParam_name(String param_name) {
    this.param_name = param_name;
  }

  public String getParam_value() {
    return param_value;
  }

  public void setParam_value(String param_value) {
    this.param_value = param_value;
  }

  public String getSubjects() {
    return subjects;
  }

  public void setSubjects(String subjects) {
    this.subjects = subjects;
  }

  public String getComments() {
    return comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Date getCreate_time() {
    return create_time;
  }

  public void setCreate_time(Date create_time) {
    this.create_time = create_time;
  }
}
