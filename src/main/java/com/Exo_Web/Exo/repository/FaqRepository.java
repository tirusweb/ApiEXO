package com.Exo_Web.Exo.repository;

import com.Exo_Web.Exo.entity.Faq;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaqRepository extends JpaRepository<Faq, String> {
}
