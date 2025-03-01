package com.Exo_Web.Exo.service;


import com.Exo_Web.Exo.dto.request.ContactCreationRequest;
import com.Exo_Web.Exo.dto.request.ContactUpdateRequest;
import com.Exo_Web.Exo.dto.request.EmployeeCreationRequest;
import com.Exo_Web.Exo.dto.request.EmployeeUpdateRequest;
import com.Exo_Web.Exo.dto.response.ContactResponse;
import com.Exo_Web.Exo.dto.response.EmployeeResponse;
import com.Exo_Web.Exo.entity.Contact;
import com.Exo_Web.Exo.entity.Employee;
import com.Exo_Web.Exo.mapper.ContactMapper;
import com.Exo_Web.Exo.mapper.EmployeeMapper;
import com.Exo_Web.Exo.repository.ContactRepository;
import com.Exo_Web.Exo.repository.EmployeeRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ContactService {

    ContactRepository contactRepository;
    ContactMapper contactMapper;


    public ContactResponse createContactRequest(ContactCreationRequest request) {



        Contact contact = contactMapper.toContact(request);
        contact = contactRepository.save(contact);
        ContactResponse response = contactMapper.toContactResponse(contact);
        return response;

    }

    public List<ContactResponse> getAllContact() {
        log.info("getAllContact");
        return contactRepository.findAll().stream()
                .map(contactMapper::toContactResponse).toList();
    }
    public void deleteContact(String contactId){
        if(!contactRepository.existsById(contactId)){
            throw new RuntimeException("Contact not found");
        }

        contactRepository.deleteById(contactId);
    }

    @Transactional
    public ContactResponse updateContact(ContactUpdateRequest request , String contactId){
        Contact contact = contactRepository.findById(contactId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        contactMapper.updateContact(contact,request);
        return contactMapper.toContactResponse(contactRepository.save(contact));

    }

}
