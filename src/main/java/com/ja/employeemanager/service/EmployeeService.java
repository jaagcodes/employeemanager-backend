package com.ja.employeemanager.service;

import com.ja.employeemanager.exception.UserNotFoundException;
import com.ja.employeemanager.model.Employee;
import com.ja.employeemanager.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo){
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees(){
        return employeeRepo.findAll();
    }

    public Employee findEmployeeById(Long id){
        return employeeRepo.findById(id).orElseThrow(()-> new UserNotFoundException("Employee by " + id + "was not found"));
    }

    public Employee findEmployeeByName(String name){
        return employeeRepo.findEmployeeByName(name).orElseThrow(()-> new UserNotFoundException("Employee by " + name + "was not found"));
    }

    public void deleteById(Long id){
        employeeRepo.deleteById(id);
    }


}
