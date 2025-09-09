package org.example.matrixspring.model;

import lombok.*;
import org.example.matrixspring.enums.DepartmentStatus;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DepartmentDto {
    private Long id;
    private String departmentName;
    private DepartmentStatus departmentStatus;
}
