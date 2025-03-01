package com.Exo_Web.Exo.repository;


import com.Exo_Web.Exo.entity.Contact;
import com.Exo_Web.Exo.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JobRepository extends JpaRepository<Job, String> {
    boolean existsByJobId(String jobId);
    Optional<Job> findByName(String name);
}
