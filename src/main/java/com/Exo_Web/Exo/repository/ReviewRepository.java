package com.Exo_Web.Exo.repository;


import com.Exo_Web.Exo.entity.Employee;
import com.Exo_Web.Exo.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, String> {

}
