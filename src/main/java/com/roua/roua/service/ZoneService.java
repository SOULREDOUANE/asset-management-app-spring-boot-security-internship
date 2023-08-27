package com.roua.roua.service;
import com.roua.roua.domain.Zone;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.roua.roua.repository.ZoneRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class ZoneService {
  private final ZoneRepository zoneRepository;
    
  public void saveNewZone(Zone zone){
      zoneRepository.save(zone);
      
  }
  public List<Zone> getAllZones(){
      return zoneRepository.findAll();
  }
  public Optional<Zone> getZonesByName(String name){
      return zoneRepository.findByName(name);
  }

  public Optional<Zone> getZoneById(Integer zoneId){
    return zoneRepository.findById(zoneId);
  }

public boolean deleteZone(Integer id){
    try {
        zoneRepository.deleteById(id);
        return true; // Deletion successful
    } catch (EmptyResultDataAccessException e) {
        return false; // Zone with the given ID was not found
    }
}

  public void deleteAllZones(List<Integer> zoneIds){
      zoneRepository.deleteAllByIdInBatch(zoneIds);
  }
    
  public Zone updateZone(Integer id, Zone updatedZone) {
        Optional<Zone> existingZoneOptional = zoneRepository.findById(id);
        
        if (existingZoneOptional.isPresent()) {
            Zone existingZone = existingZoneOptional.get();
            existingZone.setName(updatedZone.getName());
            existingZone.setDescription(updatedZone.getDescription());
            existingZone.setAddress(updatedZone.getAddress());
            existingZone.setCountry(updatedZone.getCountry());
            existingZone.setCity(updatedZone.getCity());
            existingZone.setZipCode(updatedZone.getZipCode());
            
            return zoneRepository.save(existingZone);
        } else {
            // Zone with the given ID not found
            throw new EntityNotFoundException("Zone with id " + id + " not found");
        }
    }
}
