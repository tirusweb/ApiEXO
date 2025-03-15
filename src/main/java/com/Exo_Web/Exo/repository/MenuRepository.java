package com.Exo_Web.Exo.repository;


import com.Exo_Web.Exo.entity.Employee;
import com.Exo_Web.Exo.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, String> {

}
