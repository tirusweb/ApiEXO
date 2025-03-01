package com.Exo_Web.Exo.service;


import com.Exo_Web.Exo.dto.request.CompanyCreationRequest;
import com.Exo_Web.Exo.dto.request.CompanyUpdateRequest;
import com.Exo_Web.Exo.dto.request.ContactCreationRequest;
import com.Exo_Web.Exo.dto.request.ContactUpdateRequest;
import com.Exo_Web.Exo.dto.response.CompanyResponse;
import com.Exo_Web.Exo.dto.response.ContactResponse;
import com.Exo_Web.Exo.entity.CompanyInfor;
import com.Exo_Web.Exo.entity.Contact;
import com.Exo_Web.Exo.mapper.CompanyMapper;
import com.Exo_Web.Exo.repository.CompanyRepository;
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
public class CompanyService {
    CompanyRepository companyRepository;
    CompanyMapper companyMapper;

    public CompanyResponse createCompanyRequest(CompanyCreationRequest request) {
        CompanyInfor companyInfor = companyMapper.toCompanyInfor(request);
        companyInfor = companyRepository.save(companyInfor);
        CompanyResponse response = companyMapper.toCompanyInforResponse(companyInfor);
        return response;

    }

    public List<CompanyResponse> getAllCompanyInfor() {
        log.info("getAllCompanyInfor");
        return companyRepository.findAll().stream()
                .map(companyMapper::toCompanyInforResponse).toList();
    }
    public void deleteCompanyInfor(String companyId) {
        if(!companyRepository.existsById(companyId)){
            throw new RuntimeException("Contact not found");
        }

        companyRepository.deleteById(companyId);
    }

    @Transactional
    public CompanyResponse updateCompany(CompanyUpdateRequest request , String companyId){
        CompanyInfor companyInfor = companyRepository.findById(companyId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        companyMapper.updateCompanyInfor(companyInfor,request);
        return companyMapper.toCompanyInforResponse(companyRepository.save(companyInfor));

    }
}
