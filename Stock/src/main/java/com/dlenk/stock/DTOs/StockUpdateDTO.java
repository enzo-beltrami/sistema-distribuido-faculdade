package com.dlenk.stock.DTOs;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

public class StockUpdateDTO {
  @NotNull
  @NotEmpty
  private String name;
  @NotNull
  @NotEmpty
  private String size;
  @NotNull
  @NotEmpty
  private Double price;
  @NotNull
  @NotEmpty
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
