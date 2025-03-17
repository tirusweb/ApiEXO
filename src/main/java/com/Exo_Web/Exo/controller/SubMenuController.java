package com.Exo_Web.Exo.controller;


import com.Exo_Web.Exo.dto.request.*;
import com.Exo_Web.Exo.dto.response.EmployeeResponse;
import com.Exo_Web.Exo.dto.response.SubMenuResponse;
import com.Exo_Web.Exo.service.SubMenuService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/submenus")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE , makeFinal = true)

public class SubMenuController {
    SubMenuService subMenuService;


    @GetMapping
    public ApiResponse<List<SubMenuResponse>> getAllSubMenus() {
        return new ApiResponse<>(subMenuService.getAllSubMenus());
    }

    // 🔍 Lấy Employee theo ID
    @GetMapping("/{type}")
    public ApiResponse<List<SubMenuResponse>> getMenuByType(@PathVariable String type) {
        return new ApiResponse<>(subMenuService.getSubMenuByType(type));
    }


    // 🆕 Tạo mới Employee
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<SubMenuResponse> createSubMenus(@RequestBody @Valid SubMenuCreationRequest request) {
        return new ApiResponse<>(subMenuService.createSubMenu(request));
    }

    // 🆕 Cập nhật Employee
    @PutMapping("/{id}")
    public ApiResponse<SubMenuResponse> updateSubMenu(@PathVariable String id, @RequestBody @Valid SubMenuUpdateRequest request) {
        return new ApiResponse<>(subMenuService.updateSubMenu(id, request));
    }

    // ❌ Xóa Employee
    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteSubMenus(@PathVariable String id) {
        subMenuService.deleteSubMenu(id);
        return new ApiResponse<>("Deleted successfully");
    }
}
