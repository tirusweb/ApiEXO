package com.Exo_Web.Exo.mapper;


import com.Exo_Web.Exo.dto.request.ContactCreationRequest;
import com.Exo_Web.Exo.dto.request.ContactUpdateRequest;
import com.Exo_Web.Exo.dto.request.EmployeeCreationRequest;
import com.Exo_Web.Exo.dto.request.EmployeeUpdateRequest;
import com.Exo_Web.Exo.dto.response.ContactResponse;
import com.Exo_Web.Exo.dto.response.EmployeeResponse;
import com.Exo_Web.Exo.entity.Contact;
import com.Exo_Web.Exo.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface ContactMapper {
    Contact toContact(ContactCreationRequest contact);
    ContactResponse toContactResponse(Contact contact);
    void updateContact(@MappingTarget Contact contact , ContactUpdateRequest  request);

}
