package org.example.matrixspring.dao.repository;

import org.example.matrixspring.dao.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.management.relation.Role;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
}
