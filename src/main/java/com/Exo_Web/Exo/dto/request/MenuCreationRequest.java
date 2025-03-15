package com.Exo_Web.Exo.dto.request;

import jakarta.validation.Valid;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class MenuCreationRequest {
    String homesTab;
    String aboutsTab;
    String servicesTab;
    String outWorksTab;
    String blogTab;
    String recruitmentTab;

    Set<@Valid SubMenuCreationRequest> subMenuCreationRequests;
}
