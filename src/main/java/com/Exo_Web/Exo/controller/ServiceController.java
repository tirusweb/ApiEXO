package com.Exo_Web.Exo.controller;

import com.Exo_Web.Exo.dto.request.ApiResponse;
import com.Exo_Web.Exo.dto.request.ServiceCreationRequest;
import com.Exo_Web.Exo.dto.request.ServiceUpdateRequest;
import com.Exo_Web.Exo.dto.response.ServiceResponse;
import com.Exo_Web.Exo.service.ServiceService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ServiceController {
    ServiceService serviceService;

    @PostMapping
    public ApiResponse<ServiceResponse> create(@RequestBody @Valid ServiceCreationRequest request) {
        ApiResponse<ServiceResponse> response = new ApiResponse<>();
        response.setResult(serviceService.createService(request));
        return response;
    }

    @GetMapping
    public ApiResponse<List<ServiceResponse>> getAll() {
        ApiResponse<List<ServiceResponse>> response = new ApiResponse<>();
        response.setResult(serviceService.getAllServices());
        return response;
    }

    @GetMapping("/{serviceId}")
    public ApiResponse<ServiceResponse> getServiceById(@PathVariable("serviceId") String serviceId) {
        ApiResponse<ServiceResponse> response = new ApiResponse<>();
        response.setResult(serviceService.getServiceById(serviceId));
        return response;
    }

    @PutMapping("/{serviceId}")
    public ApiResponse<ServiceResponse> update(@PathVariable("serviceId") String serviceId, @RequestBody @Valid ServiceUpdateRequest request) {
        ApiResponse<ServiceResponse> response = new ApiResponse<>();
        response.setResult(serviceService.updateService(serviceId, request));
        return response;
    }

    @DeleteMapping("/{serviceId}")
    public ApiResponse<?> delete(@PathVariable("serviceId") String serviceId) {
        serviceService.deleteService(serviceId);
        return ApiResponse.builder().result("Service has been deleted").build();
    }
}
