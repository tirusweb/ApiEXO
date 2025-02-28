package com.Exo_Web.Exo.mapper;

import com.Exo_Web.Exo.dto.request.FaqCreationRequest;
import com.Exo_Web.Exo.dto.request.FaqUpdateRequest;
import com.Exo_Web.Exo.dto.response.FaqResponse;
import com.Exo_Web.Exo.entity.Faq;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface FaqMapper {
    Faq toFaq(FaqCreationRequest request);

    FaqResponse toFaqResponse(Faq faq);

    void updateFaq(@MappingTarget Faq faq, FaqUpdateRequest request);
}
