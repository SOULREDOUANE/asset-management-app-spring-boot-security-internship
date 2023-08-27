package com.roua.roua.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roua.roua.domain.Product;
import com.roua.roua.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
    @GetMapping("/get/{name}")
    public Product getProductByName(@PathVariable("name") String name) {
        return productService.getProductByName(name);
    }

    @GetMapping("/create")
    public Product createProduct(Product product) {
        return productService.createProduct(product);
    }

    @GetMapping("/update/{id}")
    public Product updateProduct(@PathVariable("id") Integer id,@RequestBody Product updatedProduct) {
        return productService.updateProduct(id, updatedProduct);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable("id")  Integer id) {
        productService.deleteProduct(id);
    }
    
    @DeleteMapping("/delete/all")
    public void deleteAllProducts(@RequestBody List<Integer> productIds) {
        productService.deleteAllProducts(productIds);
    }

    
    
    
}
