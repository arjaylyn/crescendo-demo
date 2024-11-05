package com.arjay.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name="tbl_pizza")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Pizza {
    
  @Id
  private String id;

  @ManyToOne
  @JoinColumn(name = "pizza_type_id")
  private PizzaType pizzaType;

  @Enumerated(EnumType.STRING)
  private Size size;

  private Float price;
}
