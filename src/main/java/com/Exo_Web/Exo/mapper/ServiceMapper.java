package com.Exo_Web.Exo.mapper;

import com.Exo_Web.Exo.dto.request.ServiceCreationRequest;
import com.Exo_Web.Exo.dto.request.ServiceUpdateRequest;
import com.Exo_Web.Exo.dto.response.ServiceResponse;
import com.Exo_Web.Exo.entity.ServiceManager;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ServiceMapper {
    ServiceManager toService(ServiceCreationRequest request);

    ServiceResponse toServiceResponse(ServiceManager serviceManager);

    void updateService(@MappingTarget ServiceManager serviceManager, ServiceUpdateRequest request);
}
