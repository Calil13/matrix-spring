package org.example.matrixspring.service;

import org.example.matrixspring.dao.DepartmentEntity;
import org.example.matrixspring.dao.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<DepartmentEntity> getDepartments() {
        return departmentRepository.findAll();
    }

    public DepartmentEntity getDepartment(Long departmentId) {
        return departmentRepository.findById(departmentId).orElseThrow();
    }

    public void addDepartment(DepartmentEntity departmentEntity) {
        departmentRepository.save(departmentEntity);
    }

    public void editDepartment(DepartmentEntity departmentEntity, Long departmentId) {
        var department = departmentRepository.findById(departmentId).orElseThrow();
        department.setDepartmentName(department.getDepartmentName());
        departmentRepository.save(department);
    }

    public void deleteDepartment(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }
}
