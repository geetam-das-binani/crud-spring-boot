package com.example.demo.demo.services;

import org.springframework.stereotype.Service;

import com.example.demo.demo.Repository.EmpRepository;
import com.example.demo.demo.controllers.Employee;
import com.example.demo.demo.entities.EmpEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpServices {
    private EmpRepository empRepository;

    public EmpServices(EmpRepository empRepository) {
        this.empRepository = empRepository;
    }

    public String createEmp(Employee emp) {
        EmpEntity empEntity = new EmpEntity(emp.getId(),
                emp.getName(), emp.getEmail(), emp.getDepartment());
        empRepository.save(empEntity);
        return "Employee created successfully";
    }

    public List<Employee> getAllEmployees() {
        List<Employee> emp = new ArrayList<Employee>();

        for (EmpEntity employee : empRepository.findAll()) {
            Employee employee$ = new Employee(employee.getId(), employee.getName(), employee.getEmail(),
                    employee.getDepartment());
            emp.add(employee$);

        }
        return emp;
    }

    public String updateEmployeeById(Long employeeId, Employee emp) {

        try {
            Optional<EmpEntity> empEntity = empRepository.findById(employeeId);
            if (empEntity.isEmpty())
                return "false";
            empEntity = empEntity.map(employee -> {
                employee.setName(emp.getName());
                employee.setEmail(emp.getEmail());
                employee.setDepartment(emp.getDepartment());
                empRepository.save(employee);
                return employee;
            });
    
            return "true";
        } catch (Exception e) {
            return "false";
        }
    }
    public String deleteEmployeeById(Long employeeId) {
        try {
            if(!empRepository.existsById(employeeId)) return "false";
            empRepository.deleteById(employeeId);
            return "true";
        } catch (Exception e) {
            return "false";
        }
    }
}
