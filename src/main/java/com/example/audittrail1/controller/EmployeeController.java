package com.example.audittrail1.controller;

import com.example.audittrail1.dto.InputRequest;
import com.example.audittrail1.model.Employee;
import com.example.audittrail1.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/addemp")
    public String saveEmployee(@RequestBody InputRequest<Employee> request){
        return employeeService.saveEmployee(request);
    }

    @PutMapping("/update/{id}/{salary}")
    public String updateEmployeeSalary(@PathVariable int id,@PathVariable double salary, @RequestBody InputRequest<Employee> request){
        return employeeService.updateEmployee(id,salary,request);
    }
}
