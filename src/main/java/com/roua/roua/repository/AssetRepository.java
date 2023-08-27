package com.roua.roua.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roua.roua.domain.Asset;

public interface AssetRepository extends JpaRepository<Asset,Long> {
    Optional<Asset> findByName(String assetName);
    
}
