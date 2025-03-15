package com.Exo_Web.Exo.dto.response;

import com.Exo_Web.Exo.entity.SubMenu;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;



@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MenuResponse {
    String menuId;
    String homesTab;
    String aboutsTab;
    String servicesTab;
    String outWorksTab;
    String blogTab;
    String recruitmentTab;
    List<SubMenuResponse> subMenus;
}
