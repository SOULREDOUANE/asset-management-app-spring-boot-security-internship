package com.roua.roua.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.RequiredArgsConstructor;

import com.roua.roua.domain.Zone;
import com.roua.roua.service.ZoneService;

@RestController
@RequestMapping("/api/v1/zone")
@RequiredArgsConstructor
public class ZoneController {
    
    private final ZoneService zoneService;

    @PostMapping(value="/create")
    public void saveNewZone(@RequestBody Zone zone) {
        zoneService.saveNewZone(zone);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Zone>> getAllZones() {
        List<Zone> zones = zoneService.getAllZones();
        if (zones.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(zones);
        }
    }
    @GetMapping("/get/{name}")
    public ResponseEntity<Zone> getZoneByName(@PathVariable("name") String name) {
        return zoneService.getZonesByName(name)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteZone(@PathVariable("id") Integer id) {
        boolean deleted = zoneService.deleteZone(id);
        
        if (deleted) {
            return ResponseEntity.ok("Zone with ID " + id + " has been deleted.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/all")
    public ResponseEntity<String> deleteAllZones(@RequestBody List<Integer> zoneIds) {
        try {
            zoneService.deleteAllZones(zoneIds);
            return ResponseEntity.ok("Zones deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An error occurred while deleting zones: " + e.getMessage());
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Zone> updateZone(@PathVariable("id") Integer id, @RequestBody Zone updatedZone) {
        Zone zone = zoneService.updateZone(id, updatedZone);
        if (zone == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(zone);
        }
    }
  
    
    
    
    
}
