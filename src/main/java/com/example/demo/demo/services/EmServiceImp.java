package com.example.demo.demo.services;

import java.util.List;

import com.example.demo.demo.controllers.Employee;

public interface EmServiceImp {
    
    String createEmp(Employee emp);
    List<Employee> getAllEmployees();
    String deleteEmployeeById(Long employeeId);
    String updateEmployeeById(Long employeeId, Employee emp);
}
