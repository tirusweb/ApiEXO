package com.Exo_Web.Exo.repository;


import com.Exo_Web.Exo.entity.Employee;
import com.Exo_Web.Exo.entity.Review;
import com.Exo_Web.Exo.enums.ReviewType;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, String> {

    List<Review> findAllByType(String type);
}
