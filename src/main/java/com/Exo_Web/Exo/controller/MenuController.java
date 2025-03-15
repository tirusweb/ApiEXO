package com.Exo_Web.Exo.controller;


import com.Exo_Web.Exo.dto.request.*;
import com.Exo_Web.Exo.dto.response.EmployeeResponse;
import com.Exo_Web.Exo.dto.response.MenuResponse;
import com.Exo_Web.Exo.service.MenuService;
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
@RequestMapping("/menus")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE , makeFinal = true)

public class MenuController {

    MenuService menuService;


    @GetMapping
    public ApiResponse<List<MenuResponse>> getAllMenus() {
        return new ApiResponse<>(menuService.getAllMenu());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<MenuResponse> createMenu(@RequestBody @Valid MenuCreationRequest request) {
        return new ApiResponse<>(menuService.createMenu(request));
    }


    @PutMapping("/{id}")
    public ApiResponse<MenuResponse> updateMenu(@PathVariable String id, @RequestBody @Valid MenuUpdateRequest request) {
        return new ApiResponse<>(menuService.updateMenu(id, request));
    }

    // ❌ Xóa Employee
    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteMenu(@PathVariable String id) {
        menuService.deleteMenu(id);
        return new ApiResponse<>("Deleted successfully");
    }


}
