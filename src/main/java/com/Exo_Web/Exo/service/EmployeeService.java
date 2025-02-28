package com.Exo_Web.Exo.service;


import com.Exo_Web.Exo.dto.request.EmployeeCreationRequest;
import com.Exo_Web.Exo.dto.request.EmployeeUpdateRequest;
import com.Exo_Web.Exo.dto.response.EmployeeResponse;
import com.Exo_Web.Exo.entity.Employee;
import com.Exo_Web.Exo.mapper.EmployeeMapper;
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
public class EmployeeService {

    EmployeeRepository employeeRepository;
    EmployeeMapper employeeMapper;


    public EmployeeResponse createEmployeeRequest(EmployeeCreationRequest request) {



        Employee employee = employeeMapper.toEmployee(request);
        employee = employeeRepository.save(employee);
        EmployeeResponse response = employeeMapper.toEmployeeResponse(employee);
        return response;

    }

    public List<EmployeeResponse> getAllEmployees() {
        log.info("getAllEmployees");
        return employeeRepository.findAll().stream()
                .map(employeeMapper::toEmployeeResponse).toList();
    }
    public void deleteEmployee(String employeeId){
        if(!employeeRepository.existsById(employeeId)){
            throw new RuntimeException("Employee not found");
        }

        employeeRepository.deleteById(employeeId);
    }

    @Transactional
    public EmployeeResponse updateEmployee(EmployeeUpdateRequest request , String employeeId){
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        employeeMapper.updateEmployee(employee,request);
        return employeeMapper.toEmployeeResponse(employeeRepository.save(employee));

    }

}
