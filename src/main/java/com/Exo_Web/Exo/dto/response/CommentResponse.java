package com.Exo_Web.Exo.dto.response;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommentResponse {
    String commentId;
    String name;
    String contentCmt;
    LocalDate createdAt;
    LocalDate updatedAt;

}
