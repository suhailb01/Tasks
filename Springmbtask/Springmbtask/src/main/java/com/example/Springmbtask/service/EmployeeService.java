package com.example.Springmbtask.service;

import com.example.Springmbtask.dto.Employee;
import com.example.Springmbtask.repositery.EmployeeRepositery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepositery employeeRepositery;
    public Optional<Employee> getById(Integer id){
        return employeeRepositery.findById(id);
    }
    public Employee save(Employee emp){
        return employeeRepositery.save(emp);
    }

    public List<Employee> display(){
        return employeeRepositery.findAll();
    }
}
