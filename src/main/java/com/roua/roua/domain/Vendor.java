package com.roua.roua.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor 
public class Vendor {
    @Id
    @GeneratedValue
    private Integer id;
    private String vendorName;
    @Column(unique = true,
    nullable=false)
    private String vendorEmail;
    private String vendorPhone;
    private String vendorAddress;
    private String vendorCity;
    private String vendorCountry;
    private String vendorZipCode;
    private String vendorDescription;
    private String vendorWebsite;

    public Vendor(String vendorName, String vendorEmail, String vendorPhone, String vendorAddress, String vendorCity,
            String vendorCountry, String vendorZipCode, String vendorDescription, String vendorWebsite) {
        this.vendorName = vendorName;
        this.vendorEmail = vendorEmail;
        this.vendorPhone = vendorPhone;
        this.vendorAddress = vendorAddress;
        this.vendorCity = vendorCity;
        this.vendorCountry = vendorCountry;
        this.vendorZipCode = vendorZipCode;
        this.vendorDescription = vendorDescription;
        this.vendorWebsite = vendorWebsite;
    }
    
}
