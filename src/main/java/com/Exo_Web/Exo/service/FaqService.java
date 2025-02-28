package com.Exo_Web.Exo.service;

import com.Exo_Web.Exo.dto.request.FaqCreationRequest;
import com.Exo_Web.Exo.dto.request.FaqUpdateRequest;
import com.Exo_Web.Exo.dto.response.FaqResponse;
import com.Exo_Web.Exo.entity.Faq;
import com.Exo_Web.Exo.mapper.FaqMapper;
import com.Exo_Web.Exo.repository.FaqRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FaqService {

    FaqRepository faqRepository;
    FaqMapper faqMapper;

    public FaqResponse createFaq(FaqCreationRequest request) {
        Faq faq = faqMapper.toFaq(request);
        faq = faqRepository.save(faq);
        return faqMapper.toFaqResponse(faq);
    }

    public List<FaqResponse> getAllFaqs() {
        return faqRepository.findAll().stream()
                .map(faqMapper::toFaqResponse)
                .toList();
    }

    public FaqResponse getFaqById(String id) {
        Faq faq = faqRepository.findById(id).orElseThrow(() -> new RuntimeException("Faq not found"));
        return faqMapper.toFaqResponse(faq);
    }

    public FaqResponse updateFaq(String id, FaqUpdateRequest request) {
        Faq faq = faqRepository.findById(id).orElseThrow(() -> new RuntimeException("Faq not found"));
        faqMapper.updateFaq(faq, request);
        return faqMapper.toFaqResponse(faqRepository.save(faq));
    }

    public void deleteFaq(String id) {
        Faq faq = faqRepository.findById(id).orElseThrow(() -> new RuntimeException("Faq not found"));
        faqRepository.delete(faq);
    }
}
