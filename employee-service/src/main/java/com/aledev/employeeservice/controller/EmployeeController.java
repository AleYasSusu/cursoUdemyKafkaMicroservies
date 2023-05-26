package com.aledev.employeeservice.controller;

import com.aledev.employeeservice.dto.APIResponseDto;
import com.aledev.employeeservice.dto.EmployeeDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface EmployeeController {
    @PostMapping
    ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto);


    @GetMapping("/{id}")
    ResponseEntity<APIResponseDto> findById(@PathVariable("id") Long idEmployee);

    @GetMapping
    ResponseEntity<List<EmployeeDto>> findAll();
}
