package com.gopaljdbc.gopaljdbcprg.controller;

import com.gopaljdbc.gopaljdbcprg.dao.EmployeeDao;
import com.gopaljdbc.gopaljdbcprg.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping("/getemployees")
    public List<Employee> getEmployee(){
        return employeeDao.getEmployeeData();
    }

    @PostMapping(value="/save")
    public String saveEmployee(@RequestBody Employee employee){
        return employeeDao.insertEmployee(employee);
    }

    @GetMapping(value="/getempbyid/{id}")
    public Employee getEmpById(@PathVariable Integer id){
        return employeeDao.getEmployeeById(id);
    }

    @DeleteMapping(value="/delete/{id}")
    public String deleteEmployee(@PathVariable Integer id){
        return employeeDao.deleteEmpById(id);
    }

    @PutMapping(value="/update")
    public String updateEmp(@RequestBody Employee employee){
        return employeeDao.updateEmployee(employee);
    }

    @GetMapping("/getjoindata")
    public List<Map<String,Object>> getList(){
        return employeeDao.getEmployeeAndDepartment();
    }
}

// a) Insert employee with reference of department
// b) Check for department name not coming in the response
// c) insert into department and employee based on the check of the department existing
//// and not existing case