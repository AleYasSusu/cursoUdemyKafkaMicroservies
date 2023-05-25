package com.aledev.departamentservice.repository;

import com.aledev.departamentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentReository extends JpaRepository<Department, Long> {

    Optional<Department> findByDepartmentCode(String departmentCode);
}
