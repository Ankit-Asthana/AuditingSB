package com.example.audittrail1.service;

import com.example.audittrail1.dao.EmployeeRepository;
import com.example.audittrail1.dto.InputRequest;
import com.example.audittrail1.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public String saveEmployee(InputRequest<Employee> request){
        String currentUser=request.getLoggedInUser();
        request.setTimeZone(Calendar.getInstance().getTimeZone().getDisplayName());
        Employee employee=request.getEmployee();
        employee.setCreatedBy(currentUser);
        employeeRepository.save(employee);
        return "Employee Saved";
    }

    public String updateEmployee(int id,double salary,InputRequest<Employee> request){
        Employee employee=employeeRepository.findById(id).get();
        if(employee!=null){
            employee.setSalary(salary);
            employee.setLastModifiedBy(request.getLoggedInUser());
            employeeRepository.saveAndFlush(employee);
        }
        else {
            throw new RuntimeException("Employee not found by id "+id);
        }
        return "Employee updated successfully";
    }
}
