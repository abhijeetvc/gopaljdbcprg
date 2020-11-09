package com.gopaljdbc.gopaljdbcprg.dao;

import com.gopaljdbc.gopaljdbcprg.model.Employee;
import com.gopaljdbc.gopaljdbcprg.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;
import java.util.Map;

@Repository
public class EmployeeDao implements EmployeeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Employee> getEmployeeData() {

        String sql="select * from employee";
        List<Employee> list=jdbcTemplate.query(sql,
                new BeanPropertyRowMapper(Employee.class));
        return list;
    }

    @Override
    public String insertEmployee(Employee employee) {
        String sql="insert into employee values(?,?,?)";
        jdbcTemplate.update(sql,new Object[]{employee.getId(),
                employee.getName(),employee.getCity()});
        return "Employee added successfully";
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        String sql="select * from employee where id=?";
        Employee employee=jdbcTemplate.queryForObject(sql,new Object[]{id},
                new BeanPropertyRowMapper<>(Employee.class));
        return employee;
    }

    @Override
    public String deleteEmpById(Integer id) {

        String sql="delete from employee where id=?";
        jdbcTemplate.update(sql,new Object[]{id});
        return "Employee Deleted";
    }

    @Override
    public String updateEmployee(Employee employee) {
        String sql="update employee set name=?, city=? where id=?";
        System.out.println("Id is: "+employee.getId());
        int checkValue=jdbcTemplate.update(sql,new Object[]{employee.getName(),
                employee.getCity(),employee.getId()},new int[]{
                        Types.VARCHAR,Types.VARCHAR,Types.INTEGER});
        System.out.println("hiiiiiiii "+checkValue);
        if(checkValue==1) {
            return "Employee Updated";
        }
        return "Employee not updated";
    }

    @Override
    public List<Map<String, Object>> getEmployeeAndDepartment() {
        String sql="select a.id,a.name,a.city,b.name " +
                "from employee a,department b where a.dept_id=b.id";
        List<Map<String,Object>> list=jdbcTemplate.queryForList(sql);
        return list;
    }
}
