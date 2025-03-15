package com.Exo_Web.Exo.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String reviewId;
    @NotBlank(message = "Title cannot be null")
    String title;
    @NotBlank(message = "Content cannot be null")
    String content;
    @NotBlank(message = "Author cannot be null")
    String author;
    @JsonProperty("type")
    String type;
    int quantity;
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

    @OneToMany(mappedBy = "review" , cascade = CascadeType.ALL ,orphanRemoval = true)
    List<Comment> comments = new ArrayList<>();

}
