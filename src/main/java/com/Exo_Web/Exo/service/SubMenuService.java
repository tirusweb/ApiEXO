package com.Exo_Web.Exo.service;

import com.Exo_Web.Exo.dto.request.SkillCreationRequest;
import com.Exo_Web.Exo.dto.request.SkillUpdateRequest;
import com.Exo_Web.Exo.dto.request.SubMenuCreationRequest;
import com.Exo_Web.Exo.dto.request.SubMenuUpdateRequest;
import com.Exo_Web.Exo.dto.response.SkillResponse;
import com.Exo_Web.Exo.dto.response.SubMenuResponse;
import com.Exo_Web.Exo.entity.Employee;
import com.Exo_Web.Exo.entity.Menu;
import com.Exo_Web.Exo.entity.Skill;
import com.Exo_Web.Exo.entity.SubMenu;
import com.Exo_Web.Exo.mapper.SkillMapper;
import com.Exo_Web.Exo.mapper.SubMenuMapper;
import com.Exo_Web.Exo.repository.EmployeeRepository;
import com.Exo_Web.Exo.repository.MenuRepository;
import com.Exo_Web.Exo.repository.SkillRepository;
import com.Exo_Web.Exo.repository.SubMenuRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SubMenuService {
    SubMenuRepository subMenuRepository;
    SubMenuMapper subMenuMapper;
    MenuRepository menuRepository;

    public SubMenuResponse createSubMenu(SubMenuCreationRequest request) {
        // 🔍 Kiểm tra Employee có tồn tại không
        Menu menu = menuRepository.findById(request.getMenuId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        // 🔄 Map request sang Skill entity
        SubMenu subMenu = subMenuMapper.toSubMenu(request);
        subMenu.setMenu(menu);
        // 💾 Lưu vào DB
        subMenu = subMenuRepository.save(subMenu);

        return subMenuMapper.toSubMenuResponse(subMenu);
    }

    public List<SubMenuResponse> getAllSubMenus() {
        return subMenuRepository.findAll().stream()
                .map(subMenuMapper::toSubMenuResponse)
                .collect(Collectors.toList());
    }


    public List<SubMenuResponse> getSubMenuByType(String type) {
        List<SubMenu> subMenus = subMenuRepository.findAllByType(type);
        if (subMenus.isEmpty()) {
            throw new RuntimeException("No submenu found for type: " + type);
        }
        return subMenus.stream()
                .map(subMenuMapper::toSubMenuResponse)
                .collect(Collectors.toList());
    }


    // 🆕 Cập nhật Skill
    public SubMenuResponse updateSubMenu(String SubMenuId, SubMenuUpdateRequest request) {
        SubMenu subMenu = subMenuRepository.findById(SubMenuId)
                .orElseThrow(() -> new RuntimeException("Skill not found"));

        subMenu.setSubMenuName(request.getSubMenuName());
        subMenu.setType(request.getType());

        subMenuRepository.save(subMenu);
        return subMenuMapper.toSubMenuResponse(subMenu);
    }

    // ❌ Xóa Skill
    public void deleteSubMenu(String subMenuId) {
        SubMenu subMenu = subMenuRepository.findById(subMenuId)
                .orElseThrow(() -> new RuntimeException("Skill not found"));
        subMenuRepository.delete(subMenu);
    }
}
