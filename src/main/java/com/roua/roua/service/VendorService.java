package com.roua.roua.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.roua.roua.domain.Vendor;
import com.roua.roua.repository.VendorRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class VendorService {

    private final VendorRepository vendorRepository;
    

    public void deleteAllVendors(List<Integer> vendorIds) {
        vendorRepository.deleteAllByIdInBatch(vendorIds);
    }
    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }
    public Vendor getVendorByName(String name) {
        return vendorRepository.findByVendorName(name).orElse(null);
    }

    public Vendor createVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    public Vendor updateVendor(Integer id, Vendor updatedVendor) {
        Vendor existingVendor = vendorRepository.findById(id).orElse(null);
        if (existingVendor != null) {
            updatedVendor.setId(id);
            return vendorRepository.save(updatedVendor);
        }
        return null;
    }

    public void deleteVendor(Integer id) {
        vendorRepository.deleteById(id);
    }
}
