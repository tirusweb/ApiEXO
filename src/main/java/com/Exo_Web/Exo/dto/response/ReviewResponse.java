package com.Exo_Web.Exo.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReviewResponse {
    String reviewId;
    String title;
    String content;
    String description;
    String image;
    String author;
    String type;
    int quantity;
    LocalDate createdAt;
    LocalDate updatedAt;

    List<CommentResponse> comments;
}
