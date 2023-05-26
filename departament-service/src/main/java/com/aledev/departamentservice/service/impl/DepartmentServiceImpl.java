package com.aledev.departamentservice.service.impl;

import com.aledev.departamentservice.dto.DepartmentDto;
import com.aledev.departamentservice.entity.Department;
import com.aledev.departamentservice.exception.DepartmentCodeAlreadyException;
import com.aledev.departamentservice.exception.ResourceNotFoundException;
import com.aledev.departamentservice.mapper.AutoDepartmentMapper;
import com.aledev.departamentservice.repository.DepartmentReository;
import com.aledev.departamentservice.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentReository departmentReository;

    @Override
    public DepartmentDto createNewDepartment(DepartmentDto departmentDto) {
        Optional<Department> optionalDepartment =
                departmentReository.findByDepartmentCode(departmentDto.getDepartmentCode());
        if (optionalDepartment.isPresent()) {
            throw new DepartmentCodeAlreadyException("Department Code already exisrs for depetment.");
        }

        Department user = AutoDepartmentMapper.MAPPER.mapToDepartment(departmentDto);
        Department savedUser = departmentReository.save(user);
        return AutoDepartmentMapper.MAPPER.mapToDepartmentDto(savedUser);
    }

    @Override
    public DepartmentDto getDepartment(String department) {
        Department userExist = departmentReository.findByDepartmentCode(department).orElseThrow();
        return AutoDepartmentMapper.MAPPER.mapToDepartmentDto(userExist);
    }

    @Override
    public List<DepartmentDto> findAllDepartments() {
        List<Department> allDepartment = departmentReository.findAll();
        return allDepartment.stream()
                .map(AutoDepartmentMapper.MAPPER::mapToDepartmentDto)
                .collect(Collectors.toList());
    }

}
