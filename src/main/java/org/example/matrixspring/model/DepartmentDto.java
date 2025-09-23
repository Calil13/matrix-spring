package org.example.matrixspring.model;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.example.matrixspring.enums.DepartmentStatus;
import org.example.matrixspring.validation.OnCreate;
import org.example.matrixspring.validation.OnUpdate;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DepartmentDto {
    @NotBlank(groups = {OnCreate.class, OnUpdate.class})
    private String departmentName;
    private DepartmentStatus departmentStatus;
    @FutureOrPresent
    private LocalDate createAt;
}
