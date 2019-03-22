package com.pengshuai.uurun.hello.entity;

import java.util.Date;
import java.util.List;

public class Person {
  private int id;
  private String pName;
  private int pAge;
  private int pSex;
  private String pAddress;
  private String pTel;
  private String pComment;
  private Date createTime;
  private List<Orders> ordersList;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getpName() {
    return pName;
  }

  public void setpName(String pName) {
    this.pName = pName;
  }

  public int getpAge() {
    return pAge;
  }

  public void setpAge(int pAge) {
    this.pAge = pAge;
  }

  public int getpSex() {
    return pSex;
  }

  public void setpSex(int pSex) {
    this.pSex = pSex;
  }

  public String getpAddress() {
    return pAddress;
  }

  public void setpAddress(String pAddress) {
    this.pAddress = pAddress;
  }

  public String getpTel() {
    return pTel;
  }

  public void setpTel(String pTel) {
    this.pTel = pTel;
  }

  public String getpComment() {
    return pComment;
  }

  public void setpComment(String pComment) {
    this.pComment = pComment;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public List<Orders> getOrdersList() {
    return ordersList;
  }

  public void setOrdersList(List<Orders> ordersList) {
    this.ordersList = ordersList;
  }
}
