package com.aledev.employeeservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
@Schema(
        description = "Employee dto Model information"
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {


    private Long id;
    @Schema(
            description = "Employee first name"
    )
    @NotEmpty(message = "Employee first name should not be null or empty.")
    private String firsName;

    @Schema(
            description = "Employee last name"
    )
    @NotEmpty(message = " Employee last name should not be null or empty.")
    private String lastName;

    @Schema(
            description = "Employee email"
    )
    @Email(message = "Email address should not be valid.")
    @NotEmpty(message = "Employee Email should not be null or empty.")
    private String email;
    private String departmentCode;
}

