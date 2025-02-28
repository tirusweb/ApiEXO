package com.Exo_Web.Exo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "service")
public class ServiceManager {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String serviceId;

    @NotBlank(message = "Service name cannot be null")
    String serviceName;
    @NotBlank(message = "Service description cannot be null")
    String serviceDescription;

    LocalDate createdAt;
    LocalDate updatedAt;

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
