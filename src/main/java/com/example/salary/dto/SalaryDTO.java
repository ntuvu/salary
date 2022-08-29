package com.example.salary.dto;

import com.example.salary.entity.Salary;
import lombok.Data;

import javax.persistence.Column;

@Data
public class SalaryDTO {
  private Integer id;
  private String name;
  private Double salary;
  private String employeeId;
  private Integer month;
  private Double mealAllowance;
  private Double travelAllowance;
  private String company;

  public SalaryDTO(Salary s){
    this.id = s.getId();
    this.name = s.getName();
    this.salary = s.getSalary();
    this.employeeId = s.getEmployeeId();
    this.month = s.getMonth();
    this.mealAllowance = s.getMealAllowance();
    this.travelAllowance = s.getTravelAllowance();
    this.company = s.getCompany();
  }
}
