package com.ja.employeemanager.repo;

import com.ja.employeemanager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    public Optional<Employee> findEmployeeByName(String name);

}
