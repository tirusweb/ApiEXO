package com.Exo_Web.Exo.repository;

import com.Exo_Web.Exo.entity.Skill;
import com.Exo_Web.Exo.entity.SubMenu;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubMenuRepository extends JpaRepository<SubMenu, String> {

    List<SubMenu> findAllByType(@NotBlank(message = "Type cannot be null") String type);
}
