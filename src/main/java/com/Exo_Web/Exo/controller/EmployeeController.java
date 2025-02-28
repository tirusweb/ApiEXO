package com.Exo_Web.Exo.controller;

import com.Exo_Web.Exo.dto.request.ApiResponse;
import com.Exo_Web.Exo.dto.request.EmployeeCreationRequest;
import com.Exo_Web.Exo.dto.response.EmployeeResponse;
import com.Exo_Web.Exo.entity.Employee;
import com.Exo_Web.Exo.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE , makeFinal = true)
public class EmployeeController {
    EmployeeService employeeService;

    @PostMapping("/employee")
    public ApiResponse<EmployeeResponse> createEmployee(@RequestBody @Valid EmployeeCreationRequest request) {
        ApiResponse<EmployeeResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(employeeService.createEmployeeRequest(request));
        return apiResponse;
    }

    @GetMapping("/employee")
    public ApiResponse<List<EmployeeResponse>> getAllEmployees() {
        ApiResponse<List<EmployeeResponse>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(employeeService.getAllEmployees());
        return apiResponse;
    }

}
