package com.roua.roua.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.roua.roua.domain.Site;

public interface SiteRepository extends JpaRepository<Site,Integer>{
    Optional<Site> findByName(String siteName);

    
}
