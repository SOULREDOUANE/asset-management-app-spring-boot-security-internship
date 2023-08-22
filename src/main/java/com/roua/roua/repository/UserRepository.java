package com.roua.roua.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roua.roua.domain.User;

public interface UserRepository extends JpaRepository<User,Long>{
    Optional<User> findByEmail(String email);
}
