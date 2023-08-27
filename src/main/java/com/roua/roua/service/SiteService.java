package com.roua.roua.service;

import org.springframework.stereotype.Service;

import com.roua.roua.domain.Site;
import com.roua.roua.domain.Zone;
import com.roua.roua.repository.SiteRepository;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SiteService {
    private final SiteRepository siteRepository;
    private final ZoneService zoneService;

    public List<Site> getAllSites() {
        return siteRepository.findAll();
    }

    public Optional<Site> getSiteByName(String name) {
        return siteRepository.findByName(name);
    }

    public Site saveSite(Site site,Integer zoneId) {
        Zone zone = zoneService.getZoneById(zoneId)
            .orElseThrow(() -> new EntityNotFoundException("Zone with id " + zoneId + " not found"));
        site.setZone(zone);
        return siteRepository.save(site);
    }
    public void deleteSite(Integer id) {
        siteRepository.deleteById(id);
    }

    public Site updateSite(Integer id, Site updatedSite) {
        Optional<Site> existingSite = siteRepository.findById(id);
        if (!existingSite.isPresent()) {
            throw new EntityNotFoundException("Site with id " + id + " not found");
        }
        updatedSite.setId(id);
        return siteRepository.save(updatedSite);
    }

    public void deleteAllSites(List<Integer> siteIds) {
            siteRepository.deleteAllByIdInBatch(siteIds);
    }
    
    public Optional<Site> getSiteById(Integer siteId) {
        return siteRepository.findById(siteId);
    }


}
