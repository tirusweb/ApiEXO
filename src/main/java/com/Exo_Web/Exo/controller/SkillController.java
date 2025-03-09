package com.Exo_Web.Exo.controller;


import com.Exo_Web.Exo.dto.request.ApiResponse;
import com.Exo_Web.Exo.dto.request.EmployeeUpdateRequest;
import com.Exo_Web.Exo.dto.request.SkillCreationRequest;
import com.Exo_Web.Exo.dto.request.SkillUpdateRequest;
import com.Exo_Web.Exo.dto.response.EmployeeResponse;
import com.Exo_Web.Exo.dto.response.SkillResponse;
import com.Exo_Web.Exo.service.SkillService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/skills")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE , makeFinal = true)
@CrossOrigin(origins = "*")
public class SkillController {
    SkillService skillService;

    @PostMapping
    public ApiResponse<SkillResponse> createSkill(@RequestBody @Valid SkillCreationRequest request){
        ApiResponse<SkillResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(skillService.createSkill(request));
        return apiResponse;
    }

    @GetMapping
    public ApiResponse<List<SkillResponse>> getAllSkills() {
        ApiResponse<List<SkillResponse>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(skillService.getAllSkills());
        return apiResponse;
    }

    @GetMapping("/{id}")
    public ApiResponse<SkillResponse> getSkillById(@PathVariable String id) {
        return new ApiResponse<>(skillService.getSkillById(id));
    }


    @PutMapping("/{id}")
    public ApiResponse<SkillResponse> updateSkill(@PathVariable String id , @RequestBody @Valid SkillUpdateRequest request) {
        ApiResponse<SkillResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(skillService.updateSkill(id, request));
        return apiResponse;
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteSkill(@PathVariable String id) {
        skillService.deleteSkill(id);
        ApiResponse<String> apiResponse = new ApiResponse<>();
        apiResponse.setResult("success");
        return apiResponse;
    }

}
