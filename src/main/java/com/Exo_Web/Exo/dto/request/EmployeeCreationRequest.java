package com.Exo_Web.Exo.dto.request;

import com.Exo_Web.Exo.entity.Skill;
import jakarta.validation.Valid;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeCreationRequest {
    String name;
    String phone;
    String email;
    String address;
    String description;
    LocalDate createdAt;
    LocalDate updatedAt;

    Set<@Valid SkillCreationRequest> skills;

}
