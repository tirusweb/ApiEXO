package com.Exo_Web.Exo.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String commentId;
    @NotBlank(message = "Name cannot be null")
    String name;
    @NotBlank(message = "Content cannot be null")
    String contentCmt;
    LocalDate createdAt;
    LocalDate updatedAt;



    @ManyToOne
    @JoinColumn(name = "reviewId" , nullable = false)
    @JsonIgnore
    Review review;

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
