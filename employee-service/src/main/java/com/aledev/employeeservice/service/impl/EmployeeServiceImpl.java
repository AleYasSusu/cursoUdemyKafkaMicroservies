package com.aledev.employeeservice.service.impl;

import com.aledev.employeeservice.client.DepartmentClient;
import com.aledev.employeeservice.dto.APIResponseDto;
import com.aledev.employeeservice.dto.DepartmentDto;
import com.aledev.employeeservice.dto.EmployeeDto;
import com.aledev.employeeservice.entity.Employee;
import com.aledev.employeeservice.exception.EmployeeNotFoundException;
import com.aledev.employeeservice.exception.ResourceNotFoundException;
import com.aledev.employeeservice.mapper.AutoEmployeeMapper;
import com.aledev.employeeservice.repository.EmployeeReporitory;
import com.aledev.employeeservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeReporitory employeeReporitory;
    private final DepartmentClient departmentClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Optional<Employee> optionalUser = employeeReporitory.findById(
                employeeDto.getId());
        if (optionalUser.isPresent()) {
            throw new EmployeeNotFoundException("Employee with id ja castration");
        }

        Employee user = AutoEmployeeMapper.MAPPER.mapToEmployee(employeeDto);
        Employee savedUser = employeeReporitory.save(user);
        return AutoEmployeeMapper.MAPPER.mapToEmployeetDto(savedUser);
    }

    @Override
    public APIResponseDto findById(Long idEmployee) {
        Employee employeeExist = employeeReporitory.findById(idEmployee)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Employee", "id", idEmployee));
        DepartmentDto departmentDto = departmentClient.getDepartment(employeeExist.getDepartmentCode());
        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(AutoEmployeeMapper.MAPPER.mapToEmployeetDto(employeeExist));
        apiResponseDto.setDepartment(departmentDto);
        return apiResponseDto;

    }

    @Override
    public List<EmployeeDto> findAllUsers() {
        List<Employee> allUser = employeeReporitory.findAll();
        return allUser.stream()
                .map(AutoEmployeeMapper.MAPPER::mapToEmployeetDto)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateUser(Long id, EmployeeDto employeeDto) {
        Employee employeeExisting = employeeReporitory.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Employee", "id", id));
        employeeExisting.setFirsName(employeeDto.getFirsName());
        employeeExisting.setLastName(employeeDto.getLastName());
        employeeExisting.setEmail(employeeDto.getEmail());
        employeeExisting.setDepartmentCode(employeeDto.getDepartmentCode());
        Employee employeeUpdate = employeeReporitory.save(employeeExisting);
        return AutoEmployeeMapper.MAPPER.mapToEmployeetDto(employeeUpdate);
    }
}

