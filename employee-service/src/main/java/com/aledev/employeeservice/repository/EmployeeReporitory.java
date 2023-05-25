package com.aledev.employeeservice.repository;

import com.aledev.employeeservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeReporitory extends JpaRepository<Employee, Long> {
}
