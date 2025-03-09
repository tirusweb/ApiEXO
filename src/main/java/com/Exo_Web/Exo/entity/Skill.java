package com.Exo_Web.Exo.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String skillId;
    @NotBlank(message = "Name cannot be null")
    String skillName;
    @NotBlank(message = "Name cannot be null")
    String description;

    @ManyToOne
    @JoinColumn(name = "employeeId" , nullable = false)
    @JsonIgnore
    Employee employee;



}
