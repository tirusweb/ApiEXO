package com.Exo_Web.Exo.dto.request;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SubMenuCreationRequest {
    String subMenuName;
    String type;
    String menuId;
}
