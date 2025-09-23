package org.example.matrixspring.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.matrixspring.model.DepartmentDto;
import org.example.matrixspring.service.DepartmentService;
import org.example.matrixspring.validation.OnCreate;
import org.example.matrixspring.validation.OnUpdate;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
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
    public List<DepartmentDto> getDepartments() {
        return departmentService.getDepartments();
    }

    @GetMapping("/{departmentId}")
    public DepartmentDto getDepartment(@PathVariable Long departmentId) {
        return departmentService.getDepartment(departmentId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addDepartment(@RequestBody @Validated(OnCreate.class) DepartmentDto departmentDto) {
        departmentService.addDepartment(departmentDto);
    }

    @PutMapping("/{departmentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void editDepartment(@Validated(OnUpdate.class) @RequestBody DepartmentDto departmentDto, @PathVariable Long departmentId) {
        departmentService.editDepartment(departmentDto, departmentId);
    }

    @DeleteMapping("/{departmentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDepartment(@PathVariable Long departmentId) {
        departmentService.deleteDepartment(departmentId);
    }
}
