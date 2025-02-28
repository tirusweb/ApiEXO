package com.Exo_Web.Exo.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ServiceResponse {
    String serviceId;
    String serviceName;
    String serviceDescription;
    LocalDate createdAt;
    LocalDate updatedAt;
}
