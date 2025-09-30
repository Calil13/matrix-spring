package org.example.matrixspring.service;

import lombok.extern.slf4j.Slf4j;
import org.example.matrixspring.dao.repository.DepartmentRepository;
import org.example.matrixspring.model.DepartmentDto;
import org.example.matrixspring.mapper.DepartmentMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    public DepartmentService(DepartmentRepository departmentRepository, DepartmentMapper departmentMapper) {
        this.departmentRepository = departmentRepository;
        this.departmentMapper = departmentMapper;
    }

    public List<DepartmentDto> getDepartments() {
        return departmentRepository.findAll()
                .stream()
                .map(departmentMapper::toDto)
                .collect(Collectors.toList());
    }

    public DepartmentDto getDepartment(Long departmentId) {
        log.debug("Searching for department with id {}", departmentId);
        return departmentRepository.findById(departmentId)
                .map(departmentMapper::toDto)
                .orElseThrow(() -> {
                    log.error("Department with id {} not found", departmentId);
                    return new RuntimeException("Department not found");
                });
    }

    public void addDepartment(DepartmentDto dto) {
        departmentRepository.save(departmentMapper.toEntity(dto));
    }

    public void editDepartment(DepartmentDto dto, Long departmentId) {
        var department = departmentRepository.findById(departmentId).orElseThrow();
        department.setDepartmentName(dto.getDepartmentName());
        departmentRepository.save(department);
    }

    public void deleteDepartment(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }
}
