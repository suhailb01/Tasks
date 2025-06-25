package com.example.Springmbtask.controller;

import com.example.Springmbtask.dto.Employee;
import com.example.Springmbtask.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @GetMapping("/display/{id}")
    public String getById(@PathVariable Integer id,Model model){
        Optional<Employee> employee=employeeService.getById(id);
        model.addAttribute("emp",employee.get());
        return "display";
    }
    @GetMapping
    public String index(Model model){
        Employee emp=new Employee();
        model.addAttribute("emp",emp);
        return "index";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("emp") Employee e){
       employeeService.save(e);
        return "redirect:/displayAll";
    }

    @GetMapping("/displayAll")
    public String display(Model model){
        List<Employee> employees=employeeService.display();
        model.addAttribute("emp",employees);
        return "display";
    }

}
