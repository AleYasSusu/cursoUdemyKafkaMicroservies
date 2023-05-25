package com.aledev.employeeservice.mapper;

import com.aledev.employeeservice.dto.EmployeeDto;
import com.aledev.employeeservice.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface AutoEmployeeMapper {

    AutoEmployeeMapper MAPPER = Mappers.getMapper(AutoEmployeeMapper.class);
    EmployeeDto mapToEmployeetDto(Employee department);

    Employee mapToEmployee(EmployeeDto departmentDto);
}
