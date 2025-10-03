package org.example.matrixspring.dao.repository;

import org.example.matrixspring.dao.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Long> {
}
