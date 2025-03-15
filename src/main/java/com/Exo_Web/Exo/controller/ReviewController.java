package com.Exo_Web.Exo.controller;

import com.Exo_Web.Exo.dto.request.*;
import com.Exo_Web.Exo.dto.response.EmployeeResponse;
import com.Exo_Web.Exo.dto.response.ReviewResponse;
import com.Exo_Web.Exo.dto.response.SubMenuResponse;
import com.Exo_Web.Exo.enums.ReviewType;
import com.Exo_Web.Exo.service.EmployeeService;
import com.Exo_Web.Exo.service.ReviewService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE , makeFinal = true)
public class ReviewController {
    ReviewService reviewService;

//    @PostMapping
//    public ApiResponse<EmployeeResponse> createEmployee(@RequestBody @Valid EmployeeCreationRequest request) {
//        ApiResponse<EmployeeResponse> apiResponse = new ApiResponse<>();
//        apiResponse.setResult(employeeService.createEmployee(request));
//        return apiResponse;
//    }

    @GetMapping
    public ApiResponse<List<ReviewResponse>> getAllReview() {
        return new ApiResponse<>(reviewService.getAllReviews());
    }

//    @GetMapping("/{id}")
//    public ApiResponse<ReviewResponse> getReviewById(@PathVariable String id) {
//        return new ApiResponse<>(reviewService.getReviewById(id));
//    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<ReviewResponse> createReview(@RequestBody @Valid ReviewCreationRequest request) {
        return new ApiResponse<>(reviewService.createReview(request));
    }

    @GetMapping("/{type}")
    public ApiResponse<List<ReviewResponse>> getReviewByType(@PathVariable String type) {
        return new ApiResponse<>(reviewService.getBlogByType(type));
    }


    @PutMapping("/{id}")
    public ApiResponse<ReviewResponse> updateReview(@PathVariable String id, @RequestBody @Valid ReviewUpdateRequest request) {
        return new ApiResponse<>(reviewService.updateReview(id, request));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteReview(@PathVariable String id) {
        reviewService.deleteReview(id);
        return new ApiResponse<>("Deleted successfully");
    }
}
