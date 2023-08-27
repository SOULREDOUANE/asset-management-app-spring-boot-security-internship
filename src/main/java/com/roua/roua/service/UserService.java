package com.roua.roua.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.roua.roua.domain.Department;
import com.roua.roua.domain.User;
import com.roua.roua.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final DepartmentService departmentService;

    public void saveNewUser(User user , Integer departmentId) {
        Department department = departmentService.getDepartmentById(departmentId)
            .orElseThrow(() -> new EntityNotFoundException("Department with id " + departmentId + " not found"));
        user.setDepartment(department);
        userRepository.save(user);
    }

    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    
    public User updateUser(Long id, User updatedUser) {
        Optional<User> existingUser = userRepository.findById(id);
        if (!existingUser.isPresent()) {
            throw new EntityNotFoundException("User with id " + id + " not found");
        }
        updatedUser.setId(id);
        return userRepository.save(updatedUser);
    }
    
    public void deleteAllUsers(List<Long> userIds) {
        userRepository.deleteAllByIdInBatch(userIds);
    }
    
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
    
}
