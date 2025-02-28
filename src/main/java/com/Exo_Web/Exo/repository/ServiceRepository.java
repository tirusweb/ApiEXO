package com.Exo_Web.Exo.repository;

import com.Exo_Web.Exo.entity.ServiceManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<ServiceManager, String> {
}
