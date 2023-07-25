package com.example.demo01.service;

import com.example.demo01.entity.Employee;

import java.util.List;

public interface EmployeeServices {

    List<Employee> getAllEmployee();
    void save (Employee employee);

    Employee getByID(Long id);
    void deleteViaId(long id);
}
