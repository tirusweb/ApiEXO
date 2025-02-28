package com.Exo_Web.Exo.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FaqUpdateRequest {

    String question;
    String answer;
    LocalDate createdAt;
    LocalDate updatedAt;
}
