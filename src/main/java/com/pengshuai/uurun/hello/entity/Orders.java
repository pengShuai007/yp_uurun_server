package com.pengshuai.uurun.hello.entity;

import java.util.Date;

public class Orders {
  private int id;
  private Person person;
  private String orderName;
  private int payWay;
  private Double orderPrice;
  private String orderDescribe;
  private Date createTime;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

  public String getOrderName() {
    return orderName;
  }

  public void setOrderName(String orderName) {
    this.orderName = orderName;
  }

  public int getPayWay() {
    return payWay;
  }

  public void setPayWay(int payWay) {
    this.payWay = payWay;
  }

  public Double getOrderPrice() {
    return orderPrice;
  }

  public void setOrderPrice(Double orderPrice) {
    this.orderPrice = orderPrice;
  }

  public String getOrderDescribe() {
    return orderDescribe;
  }

  public void setOrderDescribe(String orderDescribe) {
    this.orderDescribe = orderDescribe;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }
}
