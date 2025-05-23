package com.Exo_Web.Exo.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeResponse {
    String employeeId;
    String name;
    String phone;
    String email;
    String address;
    String description;
    LocalDate createdAt;
    LocalDate updatedAt;

    List<SkillResponse> skills;
}
