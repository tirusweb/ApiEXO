package com.Exo_Web.Exo.service;

import com.Exo_Web.Exo.dto.request.EmployeeCreationRequest;
import com.Exo_Web.Exo.dto.request.EmployeeUpdateRequest;
import com.Exo_Web.Exo.dto.response.EmployeeResponse;
import com.Exo_Web.Exo.entity.Employee;
import com.Exo_Web.Exo.mapper.EmployeeMapper;
import com.Exo_Web.Exo.repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmployeeService {

    EmployeeRepository employeeRepository;
    EmployeeMapper employeeMapper;

    @Transactional
    public List<EmployeeResponse> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(employeeMapper::toEmployeeResponse)
                .collect(Collectors.toList());
    }

    // 🔍 Lấy Employee theo ID
    public EmployeeResponse getEmployeeById(String employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        return employeeMapper.toEmployeeResponse(employee);
    }

    // 🆕 Tạo mới Employee
    public EmployeeResponse createEmployee(EmployeeCreationRequest request) {
        Employee employee = employeeMapper.toEmployee(request);
        employee = employeeRepository.save(employee);
        return employeeMapper.toEmployeeResponse(employee);
    }

    // 🆕 Cập nhật Employee
    public EmployeeResponse updateEmployee(String id, EmployeeUpdateRequest request) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        employeeMapper.updateEmployee(employee, request);
        employeeRepository.save(employee);
        return employeeMapper.toEmployeeResponse(employee);
    }

    // ❌ Xóa Employee
    public void deleteEmployee(String id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        employeeRepository.delete(employee);
    }
}
