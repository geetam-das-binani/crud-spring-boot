package com.example.demo.demo.controllers;

import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.demo.services.EmpServices;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class EmpController {

    private final EmpServices empServices;

    public EmpController(EmpServices empServices) {
        this.empServices = empServices;
    }

    @GetMapping("/list")
    public List<Employee> getEmployees() {
        return empServices.getAllEmployees();
    }

    @PostMapping("/create")
    public String createEmployee(@RequestBody Employee emp) {
        return empServices.createEmp(emp);

    }

    @PutMapping("/update/{id}")
    public String updateEmployee(@PathVariable("id") Long employeeId, @RequestBody Employee emp) {

        return empServices.updateEmployeeById(employeeId, emp);

    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Long employeeId) {
        return empServices.deleteEmployeeById(employeeId);
    }

}
