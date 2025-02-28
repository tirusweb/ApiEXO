package com.Exo_Web.Exo.repository;


import com.Exo_Web.Exo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee, String> {
    boolean existsByEmployeeId(String employeeId);
    Optional<Employee> findByName(String name);
}
