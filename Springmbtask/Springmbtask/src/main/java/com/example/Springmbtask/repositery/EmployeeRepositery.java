package com.example.Springmbtask.repositery;


import com.example.Springmbtask.dto.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepositery extends MongoRepository<Employee,Integer> {
}
