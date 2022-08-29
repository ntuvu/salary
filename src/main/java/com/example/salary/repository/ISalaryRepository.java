package com.example.salary.repository;

import com.example.salary.dto.SalaryDTO;
import com.example.salary.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISalaryRepository extends JpaRepository<Salary, Integer> {
  List<Salary> findByNameOrEmployeeIdLike(String name, String employeeId);
  Salary findSalaryByEmployeeIdAndMonth(String employeeId, Integer month);
  Salary findSalaryByEmployeeIdAndCompany(String employeeId, String company);
}
