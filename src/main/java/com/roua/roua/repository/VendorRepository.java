package com.roua.roua.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roua.roua.domain.Vendor;

import java.util.Optional;


public interface VendorRepository extends JpaRepository<Vendor,Integer> {
    Optional<Vendor> findByVendorName(String vendorName);
    // void deleteAllByVendorId(List<Integer> vendorIds);
}
