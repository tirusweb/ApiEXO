package com.Exo_Web.Exo.controller;

import com.Exo_Web.Exo.dto.request.ApiResponse;
import com.Exo_Web.Exo.dto.request.EmployeeCreationRequest;
import com.Exo_Web.Exo.dto.request.EmployeeUpdateRequest;
import com.Exo_Web.Exo.dto.response.EmployeeResponse;
import com.Exo_Web.Exo.service.EmployeeService;
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
@RequestMapping("/employees")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE , makeFinal = true)
public class EmployeeController {
    EmployeeService employeeService;

//    @PostMapping
//    public ApiResponse<EmployeeResponse> createEmployee(@RequestBody @Valid EmployeeCreationRequest request) {
//        ApiResponse<EmployeeResponse> apiResponse = new ApiResponse<>();
//        apiResponse.setResult(employeeService.createEmployee(request));
//        return apiResponse;
//    }

    @GetMapping
    public ApiResponse<List<EmployeeResponse>> getAllEmployees() {
        return new ApiResponse<>(employeeService.getAllEmployees());
    }

    // 🔍 Lấy Employee theo ID
    @GetMapping("/{id}")
    public ApiResponse<EmployeeResponse> getEmployeeById(@PathVariable String id) {
        return new ApiResponse<>(employeeService.getEmployeeById(id));
    }

    // 🆕 Tạo mới Employee
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<EmployeeResponse> createEmployee(@RequestBody @Valid EmployeeCreationRequest request) {
        return new ApiResponse<>(employeeService.createEmployee(request));
    }

    // 🆕 Cập nhật Employee
    @PutMapping("/{id}")
    public ApiResponse<EmployeeResponse> updateEmployee(@PathVariable String id, @RequestBody @Valid EmployeeUpdateRequest request) {
        return new ApiResponse<>(employeeService.updateEmployee(id, request));
    }

    // ❌ Xóa Employee
    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteEmployee(@PathVariable String id) {
        employeeService.deleteEmployee(id);
        return new ApiResponse<>("Deleted successfully");
    }
}
