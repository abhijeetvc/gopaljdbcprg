package com.gopaljdbc.gopaljdbcprg.controller;

import com.gopaljdbc.gopaljdbcprg.dao.EmployeeDao;
import com.gopaljdbc.gopaljdbcprg.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping("/getemployees")
    public List<Employee> getEmployee(){
        return employeeDao.getEmployeeData();
    }
}
