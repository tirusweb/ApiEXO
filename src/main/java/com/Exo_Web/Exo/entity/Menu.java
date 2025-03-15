package com.Exo_Web.Exo.entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String menuId;
    String homesTab;
    String aboutsTab;
    String servicesTab;
    String outWorksTab;
    String blogTab;
    String recruitmentTab;

    @OneToMany(mappedBy = "menu" , cascade = CascadeType.ALL , orphanRemoval = true)
    List<SubMenu> subMenus = new ArrayList<>();

}
