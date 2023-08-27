package com.roua.roua.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roua.roua.domain.Vendor;
import com.roua.roua.service.VendorService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/vendor")
@RequiredArgsConstructor
public class VendorController {

    private final VendorService vendorService;

    @GetMapping("/all")
    public List<Vendor> getAllVendors() {
        return vendorService.getAllVendors();
    }
    @GetMapping("/get/{name}")
    public Vendor getVendorByName(@PathVariable("name") String name) {
        return vendorService.getVendorByName(name);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAllVendors(@RequestBody List<Integer> vendorIds) {
        vendorService.deleteAllVendors(vendorIds);
    }

    @PostMapping("/create")
    public Vendor createVendor(@RequestBody Vendor vendor) {
        return vendorService.createVendor(vendor);
    }

    @GetMapping("/update/{id}")
    public Vendor updateVendor(@PathVariable("id") Integer id, @RequestBody Vendor updatedVendor) {
        return vendorService.updateVendor(id, updatedVendor);
    }

    @GetMapping("/delete/{id}")
    public void deleteVendor(@PathVariable("id") Integer id) {
        vendorService.deleteVendor(id);
    }

    
}
