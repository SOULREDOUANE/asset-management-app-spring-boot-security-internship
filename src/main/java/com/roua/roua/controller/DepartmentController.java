package com.roua.roua.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roua.roua.domain.Department;
import com.roua.roua.domain.User;
import com.roua.roua.service.DepartmentService;
import com.roua.roua.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/department")

public class DepartmentController {
    private final DepartmentService departmentService;
    @GetMapping("/all")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }
    @GetMapping("/get/{name}")
    public Department getDepartmentByName(@PathVariable("name")  String name) {
        return departmentService.getDepartmentByName(name);
    }

    @PostMapping("/create/site/{siteId}/manager/{managerId}")
    public Department createDepartment(Department department, @PathVariable("siteId") Integer siteId, @PathVariable("managerId") Long managerId) {
        return departmentService.createDepartment(department, siteId, managerId);
    }

    @PutMapping("/update/{id}")
    public Department updateDepartment(@PathVariable("id")  Integer id, @RequestBody Department updatedDepartment) {
        return departmentService.updateDepartment(id, updatedDepartment);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteDepartment( @PathVariable("id") Integer id) {
        departmentService.deleteDepartment(id);
    }
    @DeleteMapping("/delete/all")
    public void deleteAllDepartments(List<Integer> departmentIds) {
        departmentService.deleteAllDepartments(departmentIds);
    }
}
