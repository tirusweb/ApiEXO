package com.Exo_Web.Exo.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class SubMenuResponse {
    String subMenuId;
    String subMenuName;
    String type;
}
