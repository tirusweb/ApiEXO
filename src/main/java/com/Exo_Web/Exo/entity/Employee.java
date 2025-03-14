package com.Exo_Web.Exo.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String employeeId;
    @NotBlank(message = "Name cannot be null")
    String name;
    @Pattern(regexp = "^[0-9]{10,11}$", message = "Invalid phone number")
    String phone;
    @Email
    String email;
    @NotBlank(message = "Address cannot be null")
    String address;
    @NotBlank(message = "Description cannot be null")
    String description;
    LocalDate createdAt;
    LocalDate updatedAt;

    @OneToMany(mappedBy = "employee" , cascade = CascadeType.ALL , orphanRemoval = true)
    List<Skill> skills = new ArrayList<>();

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDate.now();
        updatedAt = LocalDate.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDate.now();
    }


}
