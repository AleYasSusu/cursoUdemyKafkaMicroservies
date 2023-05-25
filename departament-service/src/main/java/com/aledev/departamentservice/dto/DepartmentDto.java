package com.aledev.departamentservice.dto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {
    private Long id;

    private String departmentName;

    private String departmentDescription;

    private String departmentCode;
}
