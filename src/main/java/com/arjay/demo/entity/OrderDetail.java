package com.arjay.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="tbl_order_detail")
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail {
    
  @Id
  private long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "order_id")
  private Order order;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "pizza_id")
  private Pizza pizza;

  private short quantity;
}
