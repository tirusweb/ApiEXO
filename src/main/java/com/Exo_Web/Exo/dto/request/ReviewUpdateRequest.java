package com.Exo_Web.Exo.dto.request;

import jakarta.validation.Valid;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Set;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReviewUpdateRequest {
    String title;
    String content;
    String description;
    String image;
    String author;
    String type;
    int quantity;
    LocalDate createdAt;
    LocalDate updatedAt;


}
