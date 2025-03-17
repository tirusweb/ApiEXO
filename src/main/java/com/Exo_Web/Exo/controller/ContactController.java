package com.Exo_Web.Exo.controller;

import com.Exo_Web.Exo.dto.request.*;
import com.Exo_Web.Exo.dto.response.ContactResponse;
import com.Exo_Web.Exo.dto.response.EmployeeResponse;
import com.Exo_Web.Exo.service.ContactService;
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
@RequestMapping("/api/contacts")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE , makeFinal = true)
public class ContactController {
    ContactService contactService;

    @PostMapping
    public ApiResponse<ContactResponse> createContact(@RequestBody @Valid ContactCreationRequest request) {
        ApiResponse<ContactResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(contactService.createContactRequest(request));
        return apiResponse;
    }

    @GetMapping
    public ApiResponse<List<ContactResponse>> getAllContact() {
        ApiResponse<List<ContactResponse>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(contactService.getAllContact());
        return apiResponse;
    }

    @PutMapping("/{id}")
    public ApiResponse<ContactResponse> updateContact(@PathVariable String id , @RequestBody @Valid ContactUpdateRequest request) {
        ApiResponse<ContactResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(contactService.updateContact(request, id));
        return apiResponse;
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteContact(@PathVariable String id) {
        contactService.deleteContact(id);
        ApiResponse<String> apiResponse = new ApiResponse<>();
        apiResponse.setResult("success");
        return apiResponse;
    }
}
