package com.Exo_Web.Exo.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SubMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String subMenuId;
    @NotBlank(message = "SubName cannot be null")
    String subMenuName;
    @NotBlank(message = "Type cannot be null")
    String type;

    @ManyToOne
    @JoinColumn(name = "menuId", nullable = false)
    @JsonIgnore
    Menu menu;

}
