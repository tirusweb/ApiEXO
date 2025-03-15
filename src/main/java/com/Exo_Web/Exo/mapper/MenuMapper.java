package com.Exo_Web.Exo.mapper;


import com.Exo_Web.Exo.dto.request.*;
import com.Exo_Web.Exo.dto.response.EmployeeResponse;
import com.Exo_Web.Exo.dto.response.MenuResponse;
import com.Exo_Web.Exo.dto.response.SkillResponse;
import com.Exo_Web.Exo.dto.response.SubMenuResponse;
import com.Exo_Web.Exo.entity.Employee;
import com.Exo_Web.Exo.entity.Menu;
import com.Exo_Web.Exo.entity.Skill;
import com.Exo_Web.Exo.entity.SubMenu;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.Set;
import java.util.stream.Collectors;


@Mapper(componentModel = "spring")
public interface MenuMapper {
    Menu toMenu(MenuCreationRequest menu);
    MenuResponse toMenuResponse(Menu menu);
    SubMenuResponse toSubMenuResponse(SubMenu subMenu);
    void updateMenu(@MappingTarget Menu menu , MenuUpdateRequest request);


}
