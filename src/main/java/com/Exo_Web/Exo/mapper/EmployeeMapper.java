package com.Exo_Web.Exo.mapper;


import com.Exo_Web.Exo.dto.request.EmployeeCreationRequest;
import com.Exo_Web.Exo.dto.request.EmployeeUpdateRequest;
import com.Exo_Web.Exo.dto.request.SkillCreationRequest;
import com.Exo_Web.Exo.dto.response.EmployeeResponse;
import com.Exo_Web.Exo.dto.response.SkillResponse;
import com.Exo_Web.Exo.entity.Employee;
import com.Exo_Web.Exo.entity.Skill;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.Set;
import java.util.stream.Collectors;


@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    Employee toEmployee(EmployeeCreationRequest employee);
    EmployeeResponse toEmployeeResponse(Employee employee);
    SkillResponse toSkillResponse(Skill skill);
   @Mapping(target = "createdAt" , ignore = true)
    void updateEmployee(@MappingTarget Employee employee , EmployeeUpdateRequest  request);

    default Set<Skill> mapSkills(Set<SkillCreationRequest> skills) {
        return skills != null ? skills.stream()
                .map(skillRequest -> Skill.builder()
                        .skillName(skillRequest.getSkillName())
                        .description(skillRequest.getDescription())
                        .build())
                .collect(Collectors.toSet()) : null;
    }
}
