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

    @GetMapping("/{department-code}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("department-code") String department) {
        DepartmentDto userDto = departmentService.getDepartment(department);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

}
