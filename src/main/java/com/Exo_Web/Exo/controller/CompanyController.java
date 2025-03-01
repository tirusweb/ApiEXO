package com.Exo_Web.Exo.controller;


import com.Exo_Web.Exo.dto.request.*;
import com.Exo_Web.Exo.dto.response.CompanyResponse;
import com.Exo_Web.Exo.service.CompanyService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/companys")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE , makeFinal = true)
public class CompanyController {

    CompanyService companyService;

    @PostMapping
    public ApiResponse<CompanyResponse> createCompanyInfor(@RequestBody @Valid CompanyCreationRequest request) {
        ApiResponse<CompanyResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(companyService.createCompanyRequest(request));
        return apiResponse;
    }

    @GetMapping
    public ApiResponse<List<CompanyResponse>> getAllCompanyInfor() {
        ApiResponse<List<CompanyResponse>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(companyService.getAllCompanyInfor());
        return apiResponse;
    }

    @PutMapping("/{id}")
    public ApiResponse<CompanyResponse> updateCompanyInfor(@PathVariable String id , @RequestBody @Valid CompanyUpdateRequest request) {
        ApiResponse<CompanyResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(companyService.updateCompany(request, id));
        return apiResponse;
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteEmployee(@PathVariable String id) {
        companyService.deleteCompanyInfor(id);
        ApiResponse<String> apiResponse = new ApiResponse<>();
        apiResponse.setResult("success");
        return apiResponse;
    }
}
