package com.arjay.demo.entity;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="tbl_order")
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private Date date;
  private Time time;
}