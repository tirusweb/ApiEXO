package com.Exo_Web.Exo.controller;

import com.Exo_Web.Exo.dto.request.ApiResponse;
import com.Exo_Web.Exo.dto.request.FaqCreationRequest;
import com.Exo_Web.Exo.dto.request.FaqUpdateRequest;
import com.Exo_Web.Exo.dto.response.FaqResponse;
import com.Exo_Web.Exo.service.FaqService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/faqs")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FaqController {
    FaqService faqService;

    @PostMapping
    public ApiResponse<FaqResponse> createFaq(@RequestBody @Valid FaqCreationRequest request) {
        ApiResponse<FaqResponse> response = new ApiResponse<>();
        response.setResult(faqService.createFaq(request));
        return response;
    }

    @GetMapping
    public ApiResponse<List<FaqResponse>> getAllFaqs() {
        ApiResponse<List<FaqResponse>> response = new ApiResponse<>();
        response.setResult(faqService.getAllFaqs());
        return response;
    }

    @GetMapping("/{faqId}")
    public ApiResponse<FaqResponse> getFaq(@PathVariable("faqId") String faqId) {
        ApiResponse<FaqResponse> response = new ApiResponse<>();
        response.setResult(faqService.getFaqById(faqId));
        return response;
    }

    @PutMapping("/{faqId}")
    public ApiResponse<FaqResponse> update(@PathVariable("faqId") String faqId, @RequestBody @Valid FaqUpdateRequest request) {
        ApiResponse<FaqResponse> response = new ApiResponse<>();
        response.setResult(faqService.updateFaq(faqId, request));
        return response;
    }

    @DeleteMapping("/{faqId}")
    public ApiResponse<?> delete(@PathVariable("faqId") String faqId) {
        faqService.deleteFaq(faqId);
        return ApiResponse.builder().result("Service has been deleted").build();
    }
}
