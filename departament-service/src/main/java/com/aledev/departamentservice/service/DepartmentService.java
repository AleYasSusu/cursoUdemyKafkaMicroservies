package com.aledev.departamentservice.service;

import com.aledev.departamentservice.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {

    DepartmentDto createNewDepartment(DepartmentDto departmentDto);
    
    DepartmentDto getDepartment(String department);


    List<DepartmentDto> findAllDepartments();
}
