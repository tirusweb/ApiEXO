package com.Exo_Web.Exo.mapper;

import com.Exo_Web.Exo.dto.request.SkillCreationRequest;
import com.Exo_Web.Exo.dto.request.SkillUpdateRequest;
import com.Exo_Web.Exo.dto.response.SkillResponse;
import com.Exo_Web.Exo.entity.Skill;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface SkillMapper {
    @Mapping(target = "employee", ignore = true)
    Skill toSkill(SkillCreationRequest skill);
    SkillResponse toSkillResponse(Skill skill);
    void updateSkill(@MappingTarget Skill skill, SkillUpdateRequest request);
}
