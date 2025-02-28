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
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE , makeFinal = true)
public class EmployeeController {
    EmployeeService employeeService;

    @PostMapping
    public ApiResponse<EmployeeResponse> createEmployee(@RequestBody @Valid EmployeeCreationRequest request) {
        ApiResponse<EmployeeResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(employeeService.createEmployeeRequest(request));
        return apiResponse;
    }

    @GetMapping
    public ApiResponse<List<EmployeeResponse>> getAllEmployees() {
        ApiResponse<List<EmployeeResponse>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(employeeService.getAllEmployees());
        return apiResponse;
    }

    @PutMapping("/{id}")
    public ApiResponse<EmployeeResponse> updateEmployee(@PathVariable String id , @RequestBody @Valid EmployeeUpdateRequest request) {
        ApiResponse<EmployeeResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(employeeService.updateEmployee(request, id));
        return apiResponse;
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteEmployee(@PathVariable String id) {
        employeeService.deleteEmployee(id);
        ApiResponse<String> apiResponse = new ApiResponse<>();
        apiResponse.setResult("success");
        return apiResponse;
    }
}
