package com.aledev.employeeservice.service;

import com.aledev.employeeservice.dto.APIResponseDto;
import com.aledev.employeeservice.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);


    APIResponseDto findById(Long idEmployee);

    List<EmployeeDto> findAllUsers();

    EmployeeDto updateUser(Long id, EmployeeDto employeeDto);
}
