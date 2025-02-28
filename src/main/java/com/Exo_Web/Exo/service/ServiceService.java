package com.Exo_Web.Exo.service;

import com.Exo_Web.Exo.dto.request.ServiceCreationRequest;
import com.Exo_Web.Exo.dto.request.ServiceUpdateRequest;
import com.Exo_Web.Exo.dto.response.ServiceResponse;
import com.Exo_Web.Exo.entity.ServiceManager;
import com.Exo_Web.Exo.mapper.ServiceMapper;
import com.Exo_Web.Exo.repository.ServiceRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ServiceService {

    ServiceRepository serviceRepository;
    ServiceMapper serviceMapper;

    public ServiceResponse createService(ServiceCreationRequest request) {
        ServiceManager service = serviceMapper.toService(request);
        service = serviceRepository.save(service);
        return serviceMapper.toServiceResponse(service);
    }

    public List<ServiceResponse> getAllServices() {
        return serviceRepository.findAll().stream()
                .map(serviceMapper::toServiceResponse)
                .toList();
    }

    public ServiceResponse getServiceById(String id) {
        ServiceManager serviceManager = serviceRepository.findById(id).orElseThrow(() -> new RuntimeException("Service not found"));
        return serviceMapper.toServiceResponse(serviceManager);
    }

    public ServiceResponse updateService(String id, ServiceUpdateRequest request) {
        ServiceManager serviceManager = serviceRepository.findById(id).orElseThrow(() -> new RuntimeException("Service not found"));
        serviceMapper.updateService(serviceManager, request);
        return serviceMapper.toServiceResponse(serviceRepository.save(serviceManager));
    }

    public void deleteService(String id) {
        ServiceManager serviceManager = serviceRepository.findById(id).orElseThrow(() -> new RuntimeException("Service not found"));
        serviceRepository.delete(serviceManager);
    }
}
