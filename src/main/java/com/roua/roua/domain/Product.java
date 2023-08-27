package com.roua.roua.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue
    private Integer id;
    private String productName;
    private String productDescription;
    
    public Product(String productName, String productDescription) {
        this.productName = productName;
        this.productDescription = productDescription;
    }
}
