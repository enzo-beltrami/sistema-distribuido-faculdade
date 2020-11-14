package com.dlenk.order;

public class OrderModel {

  private String id;
  private Integer itemId;
  private String userEmail;

  public OrderModel() {
  }

  public OrderModel(String id, Integer itemId, String userEmail) {
    this.id = id;
    this.itemId = itemId;
    this.userEmail = userEmail;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Integer getItemId() {
    return itemId;
  }

  public void setItemId(Integer itemId) {
    this.itemId = itemId;
  }

  public String getUserEmail() {
    return userEmail;
  }

  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
  }
}
