package com.roua.roua.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.roua.roua.domain.Product;

public interface ProductRepository extends JpaRepository<Product,Integer>{
    Optional<Product> findByProductName(String productName);
}
