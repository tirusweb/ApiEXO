package com.Exo_Web.Exo.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String jobId;
    @NotBlank(message = " name cannot be null")
    String name;
    @NotBlank(message = " link cannot be null")
    String link;
}
