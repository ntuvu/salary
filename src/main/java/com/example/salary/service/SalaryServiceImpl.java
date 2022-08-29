package com.example.salary.service;

import com.example.salary.dto.SalaryDTO;
import com.example.salary.entity.Salary;
import com.example.salary.repository.ISalaryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SalaryServiceImpl implements ISalaryService {

  @Autowired
  private ISalaryRepository salaryRepository;

  @Autowired
  private ModelMapper modelMapper;

  @Override
  public SalaryDTO create(SalaryDTO salaryDto) {
    Salary salaryRequest = modelMapper.map(salaryDto, Salary.class);
    Salary salary = salaryRepository.save(salaryRequest);
    SalaryDTO salaryResponse = modelMapper.map(salary, SalaryDTO.class);
    return salaryResponse;
  }

  @Override
  public List<SalaryDTO> showSalary(String name, String employeeId) {
    List<Salary> salaries = salaryRepository.findByNameOrEmployeeIdLike(name, employeeId);
    List<SalaryDTO> salaryDTOS = salaries.stream().map(SalaryDTO::new).collect(Collectors.toList());
    return salaryDTOS;
  }

  @Override
  public Map<String, Double> calculate(String employeeId, Integer month) {
    Salary salary = salaryRepository.findSalaryByEmployeeIdAndMonth(employeeId, month);
    return getStringDoubleMap(salary);
  }


  @Override
  public Map<String, Double> calculate(String employeeId, String company) {
    Salary salary = salaryRepository.findSalaryByEmployeeIdAndCompany(employeeId, company);
    return getStringDoubleMap(salary);
  }

  private Map<String, Double> getStringDoubleMap(Salary salary) {
    Double salaryInMonth = salary.getSalary();
    Double sumOfMealAndTravelAllowance = salary.getTravelAllowance() + salary.getMealAllowance();
    Map<String, Double> response = new HashMap<>();
    response.put("Salary", salaryInMonth);
    response.put("Total meal and travel allowance", sumOfMealAndTravelAllowance);
    return response;
  }
}
