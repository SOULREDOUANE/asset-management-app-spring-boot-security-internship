package com.roua.roua.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.roua.roua.domain.Zone;

public interface ZoneRepository extends JpaRepository<Zone,Integer>{
    Optional<Zone> findByName(String zoneName);
}
