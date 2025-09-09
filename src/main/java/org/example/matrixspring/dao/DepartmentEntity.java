package org.example.matrixspring.dao;

import jakarta.persistence.*;
import lombok.*;
import org.example.matrixspring.enums.DepartmentStatus;

import java.util.Objects;

@Entity
@Table(name = "department", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class DepartmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long departmentId;

    private String departmentName;

    @Enumerated(EnumType.STRING)
    private DepartmentStatus departmentStatus;


    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        DepartmentEntity that = (DepartmentEntity) object;
        return Objects.equals(departmentId, that.departmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(departmentId);
    }
}
