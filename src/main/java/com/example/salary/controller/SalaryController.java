package com.example.salary.controller;

import com.example.salary.dto.SalaryDTO;
import com.example.salary.entity.Salary;
import com.example.salary.service.ISalaryService;
import com.example.salary.service.SalaryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/salary")
public class SalaryController {

  @Autowired
  private ISalaryService salaryService;

  @PostMapping("/")
  public ResponseEntity<SalaryDTO> crate(@RequestBody SalaryDTO salaryDto) {
    return new ResponseEntity<>(salaryService.create(salaryDto), HttpStatus.CREATED);
  }

  @GetMapping("/show_salary")
  public ResponseEntity<List<SalaryDTO>> showSalary(
      @RequestParam(required = false) String name,
      @RequestParam(required = false) String employeeId) {
    return new ResponseEntity<>(salaryService.showSalary(name, employeeId), HttpStatus.OK);
  }

  @GetMapping(value = {"/salary_in/{month}", "/salary_in/{company}"})
  public ResponseEntity<Map<String, Double>> showTotalSalary(
      @RequestParam String employeeId,
      @PathVariable(required = false) Optional<Integer> month,
      @PathVariable(required = false) Optional<String> company
  ) {
    if (month.isPresent()) {
      return new ResponseEntity<>(salaryService.calculate(employeeId, month.get()), HttpStatus.OK);
    } else if (company.isPresent()) {
      return new ResponseEntity<>(salaryService.calculate(employeeId, company.get()), HttpStatus.OK);
    }
    return null;
  }
}
