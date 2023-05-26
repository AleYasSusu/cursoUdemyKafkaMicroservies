package com.aledev.employeeservice.controller.impl;

import com.aledev.employeeservice.controller.EmployeeController;
import com.aledev.employeeservice.dto.APIResponseDto;
import com.aledev.employeeservice.dto.EmployeeDto;
import com.aledev.employeeservice.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employees")
@RequiredArgsConstructor
public class EmployeeControllerImpl implements EmployeeController {

    private final EmployeeService employeeService;

    @Override
    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto saveEmployee = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(saveEmployee, HttpStatus.CREATED);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<APIResponseDto> findById(@PathVariable("id") Long idEmployee) {
        APIResponseDto apiResponseDto = employeeService.findById(idEmployee);
        return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> findAll() {
        List<EmployeeDto> alUser = employeeService.findAllUsers();
        return new ResponseEntity<>(alUser, HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable("id") Long employeeId,
                                           @Valid @RequestBody EmployeeDto employeeDto) {
        employeeService.updateUser(employeeId, employeeDto);
        return ResponseEntity.noContent().build();
    }
}
