package com.Exo_Web.Exo.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommentCreationRequest {
    String name;
    String contentCmt;
    LocalDate createdAt;
    LocalDate updatedAt;
    String reviewId;
}
