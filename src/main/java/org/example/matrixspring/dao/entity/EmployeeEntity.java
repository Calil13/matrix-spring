package org.example.matrixspring.dao.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "employee", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String position;
    private Integer salary;

    @ManyToMany
    @JoinTable(
            name = "employee_company",
            joinColumns = @JoinColumn(name = "employee"),
            inverseJoinColumns = @JoinColumn(name = "company")
    )
    private Set<CompanyEntity> company;
}
