package com.roua.roua.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roua.roua.domain.Asset;
import com.roua.roua.service.AssetService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/asset")
@RequiredArgsConstructor
public class AssetController {

    private final AssetService assetService;

    @GetMapping("/all")
    public ResponseEntity<List<Asset>> getAllAssets() {
        List<Asset> assets = assetService.getAllAssets();
        if (assets.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(assets);
        }
    }

    @GetMapping("/get/{name}")
    public ResponseEntity<Optional<Asset>> getAssetByName(@PathVariable("name") String name) {
        Optional<Asset> assets = assetService.getAssetByName(name);
        if (assets != null) {
            return ResponseEntity.ok(assets);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/deleteAll")
    public ResponseEntity<Void> deleteAllAssets(@RequestBody List<Long> assetIds) {
        assetService.deleteAllAssets(assetIds);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/create")
    public ResponseEntity<Asset> createAsset(Asset asset) {
        Asset createdAsset = assetService.createAsset(asset);
        if (createdAsset != null) {
            return ResponseEntity.ok(createdAsset);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/update/{id}")
    public ResponseEntity<Asset> updateAsset(@PathVariable("id") Long id, @RequestBody Asset updatedAsset) {
        Asset asset = assetService.updateAsset(id, updatedAsset);
        if (asset != null) {
            return ResponseEntity.ok(asset);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAsset(@PathVariable("id") Long id) {
        assetService.deleteAsset(id);
        return ResponseEntity.ok().build();
    }



}