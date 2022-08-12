package com.ja.employeemanager.controller;

import com.ja.employeemanager.model.Employee;
import com.ja.employeemanager.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List employees = employeeService.findAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id){
        Employee employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> registerEmployee(@RequestBody Employee employee){
        Employee newEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        System.out.println(employee);
        Employee updateEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(updateEmployee, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") Long id ){
        employeeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/findByName/{name}")
    public ResponseEntity<Employee> findEmployeeByName(@PathVariable("name") String name ){
        Employee employee = employeeService.findEmployeeByName(name);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

}
