package org.example.matrixspring.dao.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name = "address")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private String street;

    @OneToOne(mappedBy = "address")
    private DepartmentEntity department;

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        AddressEntity that = (AddressEntity) object;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
