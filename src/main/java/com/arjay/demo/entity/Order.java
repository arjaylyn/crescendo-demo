package com.arjay.demo.entity;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="tbl_order")
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Order {
    
  @Id
  @NonNull
  private Long id;

  @NonNull
  private Date date;

  @NonNull
  private Time time;

  @OneToMany(fetch = FetchType.EAGER)
  @JoinColumn(name = "order_id")
  @JsonIgnoreProperties("order")
  private List<OrderDetail> details;

  public Order(Long orderId) {
    this.id = orderId;
  }
}
