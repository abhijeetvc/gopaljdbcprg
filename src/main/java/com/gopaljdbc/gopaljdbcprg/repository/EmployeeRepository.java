package com.gopaljdbc.gopaljdbcprg.repository;

import com.gopaljdbc.gopaljdbcprg.model.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeRepository {

    List<Employee> getEmployeeData();

    String insertEmployee(Employee employee);

    Employee getEmployeeById(Integer id);

    String deleteEmpById(Integer id);

    String updateEmployee(Employee employee);

    List<Map<String,Object>> getEmployeeAndDepartment();
}
