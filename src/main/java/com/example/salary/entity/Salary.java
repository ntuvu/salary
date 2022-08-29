package com.example.salary.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Salary {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String name;
  private String employeeId;
  private Double salary;
  private Integer month;
  private Double mealAllowance;
  private Double travelAllowance;
  private String company;
}
