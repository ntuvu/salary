package com.example.salary.service;

import com.example.salary.dto.SalaryDTO;

import java.util.List;
import java.util.Map;

public interface ISalaryService {
  SalaryDTO create(SalaryDTO salaryDto);
  List<SalaryDTO> showSalary(String name, String employeeId);
  Map<String, Double> calculate(String employeeId, Integer month);
  Map<String, Double> calculate(String employeeId, String company);
}
