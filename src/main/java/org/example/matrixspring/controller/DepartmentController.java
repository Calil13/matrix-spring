package org.example.matrixspring.controller;

import org.example.matrixspring.dao.DepartmentEntity;
import org.example.matrixspring.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public List<DepartmentEntity> getDepartments() {
        return departmentService.getDepartments();
    }

    @GetMapping("/{departmentId}")
    public DepartmentEntity getDepartment(@PathVariable Long departmentId) {
        return departmentService.getDepartment(departmentId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addOrder(@RequestBody DepartmentEntity departmentEntity) {
        departmentService.addDepartment(departmentEntity);
    }

    @PutMapping("/{departmentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void editOrder(@RequestBody DepartmentEntity departmentEntity, @PathVariable Long departmentId) {
        departmentService.editDepartment(departmentEntity, departmentId);
    }

    @DeleteMapping("/{departmentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDepartment(@PathVariable Long departmentId) {
        departmentService.deleteDepartment(departmentId);
    }
}
