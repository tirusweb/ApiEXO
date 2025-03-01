package com.Exo_Web.Exo.dto.request;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CompanyUpdateRequest {
    String name;
    String email;
    String phone;
    String address;
    String description;
    Byte[] logo;
}
