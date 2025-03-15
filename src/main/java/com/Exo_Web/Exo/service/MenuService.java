package com.Exo_Web.Exo.service;

import com.Exo_Web.Exo.dto.request.EmployeeCreationRequest;
import com.Exo_Web.Exo.dto.request.EmployeeUpdateRequest;
import com.Exo_Web.Exo.dto.request.MenuCreationRequest;
import com.Exo_Web.Exo.dto.request.MenuUpdateRequest;
import com.Exo_Web.Exo.dto.response.EmployeeResponse;
import com.Exo_Web.Exo.dto.response.MenuResponse;
import com.Exo_Web.Exo.entity.Employee;
import com.Exo_Web.Exo.entity.Menu;
import com.Exo_Web.Exo.mapper.EmployeeMapper;
import com.Exo_Web.Exo.mapper.MenuMapper;
import com.Exo_Web.Exo.repository.EmployeeRepository;
import com.Exo_Web.Exo.repository.MenuRepository;
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
public class MenuService {

    MenuRepository menuRepository;
    MenuMapper menuMapper;

    @Transactional
    public List<MenuResponse> getAllMenu() {
        return menuRepository.findAll().stream()
                .map(menuMapper::toMenuResponse)
                .collect(Collectors.toList());
    }

    // 🆕 Tạo mới Employee
    public MenuResponse createMenu(MenuCreationRequest request) {
        Menu menu = menuMapper.toMenu(request);
        menu = menuRepository.save(menu);
        return menuMapper.toMenuResponse(menu);
    }

    // 🆕 Cập nhật Employee
    public MenuResponse updateMenu(String id, MenuUpdateRequest request) {
        Menu menu = menuRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Menu not found"));

        menuMapper.updateMenu(menu, request);
        menuRepository.save(menu);
        return menuMapper.toMenuResponse(menu);
    }

    // ❌ Xóa Employee
    public void deleteMenu(String id) {
        Menu menu = menuRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Menu not found"));

        menuRepository.delete(menu);
    }
}
