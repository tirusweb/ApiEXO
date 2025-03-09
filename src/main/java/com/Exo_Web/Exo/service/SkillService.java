package com.Exo_Web.Exo.service;

import com.Exo_Web.Exo.dto.request.SkillCreationRequest;
import com.Exo_Web.Exo.dto.request.SkillUpdateRequest;
import com.Exo_Web.Exo.dto.response.SkillResponse;
import com.Exo_Web.Exo.entity.Employee;
import com.Exo_Web.Exo.entity.Skill;
import com.Exo_Web.Exo.mapper.SkillMapper;
import com.Exo_Web.Exo.repository.EmployeeRepository;
import com.Exo_Web.Exo.repository.SkillRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SkillService {
    SkillRepository skillRepository;
    SkillMapper skillMapper;
    EmployeeRepository employeeRepository;

    public SkillResponse createSkill(SkillCreationRequest request) {
        // 🔍 Kiểm tra Employee có tồn tại không
        Employee employee = employeeRepository.findById(request.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        // 🔄 Map request sang Skill entity
        Skill skill = skillMapper.toSkill(request);
        skill.setEmployee(employee);
        // 💾 Lưu vào DB
        skill = skillRepository.save(skill);

        return skillMapper.toSkillResponse(skill);
    }

    public List<SkillResponse> getAllSkills() {
        return skillRepository.findAll().stream()
                .map(skillMapper::toSkillResponse)
                .collect(Collectors.toList());
    }

    // 🔍 Lấy Skill theo ID
    public SkillResponse getSkillById(String skillId) {
        Skill skill = skillRepository.findById(skillId)
                .orElseThrow(() -> new RuntimeException("Skill not found"));
        return skillMapper.toSkillResponse(skill);
    }

    // 🆕 Cập nhật Skill
    public SkillResponse updateSkill(String skillId, SkillUpdateRequest request) {
        Skill skill = skillRepository.findById(skillId)
                .orElseThrow(() -> new RuntimeException("Skill not found"));

        skill.setSkillName(request.getSkillName());
        skill.setDescription(request.getDescription());

        skillRepository.save(skill);
        return skillMapper.toSkillResponse(skill);
    }

    // ❌ Xóa Skill
    public void deleteSkill(String skillId) {
        Skill skill = skillRepository.findById(skillId)
                .orElseThrow(() -> new RuntimeException("Skill not found"));
        skillRepository.delete(skill);
    }
}
