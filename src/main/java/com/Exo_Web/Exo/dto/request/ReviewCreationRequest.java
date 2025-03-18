package com.Exo_Web.Exo.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Set;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReviewCreationRequest {
    String title;
    String content;
    String image;
    String description;
    String author;
    String type;
    int quantity;
    LocalDate createdAt;
    LocalDate updatedAt;

    Set<@Valid CommentCreationRequest> comments;

}
