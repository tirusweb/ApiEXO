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
public class ServiceCreationRequest {

    String serviceName;
    String serviceDescription;
    LocalDate createdAt;
    LocalDate updatedAt;
}
