package com.example.demo01.service;

import com.example.demo01.entity.Employee;
import com.example.demo01.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServicelmpl implements EmployeeServices {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public void save(Employee employee) {

        employeeRepository.save(employee);

    }

    @Override
    public Employee getByID(Long id) {

        Optional<Employee> optional = employeeRepository.findById(id);
        Employee employee = null;
        if(optional.isPresent()){
            employee = optional.get();
        }else {
            throw new RuntimeException(
                    "Employee not found for id : " + id);

        }

            return employee;

    }

    @Override
    public void deleteViaId(long id) {

        employeeRepository.deleteById(id);

    }
}
