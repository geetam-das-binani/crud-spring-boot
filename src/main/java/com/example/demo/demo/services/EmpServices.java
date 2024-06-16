package com.example.demo.demo.services;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.example.demo.demo.Repository.EmpRepository;
import com.example.demo.demo.controllers.Employee;
import com.example.demo.demo.entities.EmpEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpServices implements EmServiceImp {

    // *Dependency Injection */
    private EmpRepository empRepository;

    public EmpServices(EmpRepository empRepository) {
        this.empRepository = empRepository;
    }

    @Override
    public String createEmp(Employee emp) {
        EmpEntity empEntity = new EmpEntity();
        BeanUtils.copyProperties(emp, empEntity);

        empRepository.save(empEntity);
        return "Employee created successfully";
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> emp = new ArrayList<Employee>();

        for (EmpEntity employee : empRepository.findAll()) {

            Employee employee$ = new Employee();
            BeanUtils.copyProperties(employee, employee$);
            emp.add(employee$);

        }
        return emp;

    }

    @Override
    public String updateEmployeeById(Long employeeId, Employee emp) {

        try {
          Optional <EmpEntity> empEntity = empRepository.findById(employeeId);
          
            
         if (empEntity.isEmpty())return "false";

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

    @Override
    public String deleteEmployeeById(Long employeeId) {
        // EmpEntity empEntity =empRepository.findById(employeeId).get();
        try {
            if (!empRepository.existsById(employeeId))
                return "false";
            empRepository.deleteById(employeeId);
            // empRepository.delete(empEntity);
            return "true";
        } catch (Exception e) {
            return "false";
        }
    }
}
