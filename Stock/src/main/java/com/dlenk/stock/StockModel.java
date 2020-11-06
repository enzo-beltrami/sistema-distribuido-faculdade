package com.dlenk.stock;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;


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
