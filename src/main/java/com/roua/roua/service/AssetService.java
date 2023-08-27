package com.roua.roua.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.roua.roua.domain.Asset;
import com.roua.roua.repository.AssetRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AssetService {
    private final AssetRepository assetRepository;

    public void deleteAllAssets(List<Long> assetIds) {
        assetRepository.deleteAllByIdInBatch(assetIds);
    }

    public List<Asset> getAllAssets() {
        return assetRepository.findAll();
    }

    public Optional<Asset> getAssetByName(String name) {
        return assetRepository.findByName(name);
    }
    


    public Asset createAsset(Asset asset) {
        return assetRepository.save(asset);
    }

    public Asset updateAsset(Long id, Asset updatedAsset) {
        Asset existingAsset = assetRepository.findById(id).orElse(null);
        if (existingAsset != null) {
            updatedAsset.setId(id);
            return assetRepository.save(updatedAsset);
        }
        return null;
    }

    public void deleteAsset(Long id) {
        assetRepository.deleteById(id);
    }
}
