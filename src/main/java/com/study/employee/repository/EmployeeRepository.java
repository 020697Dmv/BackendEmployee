package com.study.employee.repository;

import com.study.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {


    void deleteEmployeeById(Long id);

    Optional<Employee> finEmployeeById(Long id);
}
