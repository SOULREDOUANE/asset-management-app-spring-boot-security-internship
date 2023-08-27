package com.roua.roua.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.roua.roua.domain.Department;
import com.roua.roua.domain.Site;
import com.roua.roua.domain.User;
import com.roua.roua.repository.DepartmentRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final SiteService siteService;
    private final UserService userService;

    public Department createDepartment(Department department, Integer siteId, Long managerId) {
        Site site = siteService.getSiteById(siteId)
        . orElseThrow(() -> new EntityNotFoundException("Site with id " + siteId + " not found"));
        department.setSite(site);

        User manager = userService.getUserById(managerId)
            .orElseThrow(() -> new EntityNotFoundException("User with id " + managerId + " not found"));
        department.setManager(manager);
        return departmentRepository.save(department);
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentByName(String name) {
        return departmentRepository.findByName(name).orElse(null);
    }

    public Department updateDepartment(Integer id, Department updatedDepartment) {
        Optional<Department> department = departmentRepository.findById(id);
        if (department != null) {
            updatedDepartment.setId(id);
            return departmentRepository.save(updatedDepartment);
        }
        return null;
    }

    public void deleteDepartment(Integer id) {
        departmentRepository.deleteById(id);
    }

    public void deleteAllDepartments(List<Integer> departmentIds) {
        departmentRepository.deleteAllByIdInBatch(departmentIds);
    }

    public Optional<Department> getDepartmentById(Integer departmentId) {
        return departmentRepository.findById(departmentId);
    }
    
}
