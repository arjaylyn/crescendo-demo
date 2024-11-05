package com.arjay.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="tbl_pizza_type")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PizzaType {

  @Id
  private String id;

  private String name;

  @Enumerated(EnumType.STRING)
  private PizzaCategory category;

  private String ingredients;
}
