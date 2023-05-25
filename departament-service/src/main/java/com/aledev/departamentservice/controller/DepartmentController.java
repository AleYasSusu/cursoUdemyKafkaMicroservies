package com.aledev.departamentservice.controller;

import com.aledev.departamentservice.dto.DepartmentDto;
import com.aledev.departamentservice.service.DepartmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/departments")
public class DepartmentController {
    private final DepartmentService departmentService;
    @PostMapping
    public ResponseEntity< DepartmentDto> createDepartment( @RequestBody DepartmentDto departmentDto) {
        DepartmentDto userSaved = departmentService.createNewDepartment(departmentDto);
        return new ResponseEntity<>(userSaved, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDto> findById(@PathVariable("id") Long userId) {
        DepartmentDto userDto = departmentService.findById(userId);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<DepartmentDto>> findAll() {
        List<DepartmentDto> alUser = departmentService.findAllDepartment();
        return new ResponseEntity<>(alUser, HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable("id") Long userId, @Valid @RequestBody DepartmentDto user) {
        departmentService.updateDepartment(userId, user);
        return ResponseEntity.noContent().build();
    }
}
