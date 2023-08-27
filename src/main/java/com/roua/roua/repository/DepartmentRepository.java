package com.roua.roua.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.roua.roua.domain.Department;

public interface DepartmentRepository  extends JpaRepository<Department,Integer>{
    Optional<Department> findByName(String departmentName);
}
