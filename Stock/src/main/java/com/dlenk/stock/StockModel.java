package com.dlenk.stock;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name = "stock")
public class StockModel implements Serializable {

  @Id
  @SequenceGenerator(name="stock_id_seq",
          sequenceName="stock_id_seq",
          allocationSize=1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE,
          generator="stock_id_seq")
  private Integer id;
  private String name;
  private String size;
  private Double price;
  private Integer quant;



  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
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
