package com.Exo_Web.Exo.repository;


import com.Exo_Web.Exo.entity.Contact;
import com.Exo_Web.Exo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<Contact, String> {
    boolean existsByContactId(String contactId);
    Optional<Contact> findByName(String name);
}
