package com.Exo_Web.Exo.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ContactUpdateRequest {
    String name;
    String email;
    String title;
    String message;
}
