package com.Exo_Web.Exo.controller;


import com.Exo_Web.Exo.dto.request.*;
import com.Exo_Web.Exo.dto.response.ContactResponse;
import com.Exo_Web.Exo.dto.response.JobResponse;
import com.Exo_Web.Exo.service.JobService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/jobs")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE , makeFinal = true)

public class JobController {
    JobService jobService;

    @PostMapping
    public ApiResponse<JobResponse> createJob(@RequestBody @Valid JobCreationRequest request) {
        ApiResponse<JobResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(jobService.createJobRequest(request));
        return apiResponse;
    }

    @GetMapping
    public ApiResponse<List<JobResponse>> getAllJob() {
        ApiResponse<List<JobResponse>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(jobService.getAllJob());
        return apiResponse;
    }
    @PutMapping("/{id}")
    public ApiResponse<JobResponse> updateJob(@PathVariable String id , @RequestBody @Valid JobUpdateRequest request) {
        ApiResponse<JobResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(jobService.updateJob(request, id));
        return apiResponse;
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteJob(@PathVariable String id) {
        jobService.deleteJob(id);
        ApiResponse<String> apiResponse = new ApiResponse<>();
        apiResponse.setResult("success");
        return apiResponse;
    }
}
