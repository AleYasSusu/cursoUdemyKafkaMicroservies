package com.aledev.departamentservice.service;

import com.aledev.departamentservice.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {

    DepartmentDto createNewDepartment(DepartmentDto departmentDto);

    DepartmentDto findById(Long id);

    List<DepartmentDto> findAllDepartment();

    DepartmentDto updateDepartment(Long id, DepartmentDto department);
}
