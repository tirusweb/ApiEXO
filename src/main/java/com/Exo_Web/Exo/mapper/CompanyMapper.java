package com.Exo_Web.Exo.mapper;


import com.Exo_Web.Exo.dto.request.CompanyCreationRequest;
import com.Exo_Web.Exo.dto.request.CompanyUpdateRequest;
import com.Exo_Web.Exo.dto.request.ContactCreationRequest;
import com.Exo_Web.Exo.dto.request.ContactUpdateRequest;
import com.Exo_Web.Exo.dto.response.CompanyResponse;
import com.Exo_Web.Exo.dto.response.ContactResponse;
import com.Exo_Web.Exo.entity.CompanyInfor;
import com.Exo_Web.Exo.entity.Contact;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface CompanyMapper {
    CompanyInfor toCompanyInfor(CompanyCreationRequest companyCreationRequest);
    CompanyResponse toCompanyInforResponse(CompanyInfor companyInfor);
    void updateCompanyInfor(@MappingTarget CompanyInfor companyInfor , CompanyUpdateRequest request);

}
