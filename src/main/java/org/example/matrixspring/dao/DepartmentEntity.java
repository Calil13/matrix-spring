package org.example.matrixspring.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "department")
public class DepartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long department_id;
    //    @Column(name = "order_number")
    private String departmentName;

    public DepartmentEntity() {
    }

    public DepartmentEntity(Long department_id, String departmentName) {
        this.department_id = department_id;
        this.departmentName = departmentName;
    }

    public Long getId() {
        return department_id;
    }

    public void setId(Long department_id) {
        this.department_id = department_id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String orderNumber) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "DepartmentEntity{" +
                "department_id=" + department_id +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        DepartmentEntity that = (DepartmentEntity) o;
        return Objects.equals(department_id, that.department_id) && Objects.equals(departmentName, that.departmentName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(department_id, departmentName, departmentName);
    }
}
