package org.example.matrixspring.dao.repository;

import org.example.matrixspring.dao.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {
    
}
