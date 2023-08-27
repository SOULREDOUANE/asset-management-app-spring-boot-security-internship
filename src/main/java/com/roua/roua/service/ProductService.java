package com.roua.roua.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.roua.roua.domain.Product;
import com.roua.roua.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
    
    private final ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductByName(String name) {
        return productRepository.findByProductName(name).orElse(null);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Integer id, Product updatedProduct) {
        Optional<Product> existingProduct = productRepository.findById(id);
        if (existingProduct != null) {
            updatedProduct.setId(id);
            return productRepository.save(updatedProduct);
        }
        return null;
    }

    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }
    public void deleteAllProducts(List<Integer> productIds) {
        productRepository.deleteAllByIdInBatch(productIds);
    }
}
