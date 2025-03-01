package com.Exo_Web.Exo.repository;


import com.Exo_Web.Exo.entity.CompanyInfor;
import com.Exo_Web.Exo.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyInfor, String> {
    boolean existsByCompanyId(String companyId);
    Optional<CompanyInfor> findByName(String name);
}
