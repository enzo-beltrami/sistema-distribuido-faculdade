package com.dlenk.stock.DTOs;


public class StockUpdateDTO {
  private String name;
  private String size;
  private Double price;
  private Integer quant;

  public StockUpdateDTO(String name, String size, Double price, Integer quant) {
    this.name = name;
    this.size = size;
    this.price = price;
    this.quant = quant;
  }

  public StockUpdateDTO() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Integer getQuant() {
    return quant;
  }

  public void setQuant(Integer quant) {
    this.quant = quant;
  }
}
