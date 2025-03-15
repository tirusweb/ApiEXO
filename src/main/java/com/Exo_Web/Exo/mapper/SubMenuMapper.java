package com.Exo_Web.Exo.mapper;

import com.Exo_Web.Exo.dto.request.SkillCreationRequest;
import com.Exo_Web.Exo.dto.request.SkillUpdateRequest;
import com.Exo_Web.Exo.dto.request.SubMenuCreationRequest;
import com.Exo_Web.Exo.dto.request.SubMenuUpdateRequest;
import com.Exo_Web.Exo.dto.response.SkillResponse;
import com.Exo_Web.Exo.dto.response.SubMenuResponse;
import com.Exo_Web.Exo.entity.Menu;
import com.Exo_Web.Exo.entity.Skill;
import com.Exo_Web.Exo.entity.SubMenu;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface SubMenuMapper {
    @Mapping(target = "menu", ignore = true)
    SubMenu toSubMenu(SubMenuCreationRequest subMenu);
    SubMenuResponse toSubMenuResponse(SubMenu subMenu);
    void updateSubMenu(@MappingTarget SubMenu subMenu, SubMenuUpdateRequest request);
}
