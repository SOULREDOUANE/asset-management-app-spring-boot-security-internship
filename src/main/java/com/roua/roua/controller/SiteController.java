package com.roua.roua.controller;
import org.springframework.web.bind.annotation.RestController;

import com.roua.roua.domain.Site;
import com.roua.roua.service.SiteService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.RequiredArgsConstructor;
@RestController
@RequestMapping("/api/v1/site")
@RequiredArgsConstructor
public class SiteController {
    private final SiteService siteService;
    
    @GetMapping("/all")
    public ResponseEntity<List<Site>> getAllSites() {
        List<Site> sites = siteService.getAllSites();
        if (sites.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(sites);
        }
    }
    @GetMapping("/get/{name}")
    public ResponseEntity<Site> getSiteByName(@PathVariable("name") String name) {
        return siteService.getSiteByName(name)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/create/{zoneId}")
    public ResponseEntity<Site> createSite(@RequestBody Site site,@PathVariable("zoneId") Integer zoneId) {
        
        Site createdSite = siteService.saveSite(site, zoneId);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSite);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Site> updateSite(@PathVariable("id") Integer id, @RequestBody Site updatedSite) {

        Site site = siteService.updateSite(id, updatedSite);
        if (site == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(site);
        }
    }

    @DeleteMapping("/delete/all")
    public ResponseEntity<String> deleteAllSites(@RequestBody List<Integer> siteIds) {
        try {
            siteService.deleteAllSites(siteIds);
            return ResponseEntity.ok("Sites deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An error occurred while deleting sites: " + e.getMessage());
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSite(@PathVariable("id") Integer id) {
        try {
            siteService.deleteSite(id);
            return ResponseEntity.ok("Site with ID " + id + " has been deleted.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An error occurred while deleting site: " + e.getMessage());
        }
    }




}

