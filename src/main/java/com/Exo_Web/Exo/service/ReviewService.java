package com.Exo_Web.Exo.service;

import com.Exo_Web.Exo.dto.request.ReviewCreationRequest;
import com.Exo_Web.Exo.dto.request.ReviewUpdateRequest;
import com.Exo_Web.Exo.dto.response.ReviewResponse;
import com.Exo_Web.Exo.entity.Review;
import com.Exo_Web.Exo.mapper.ReviewMapper;
import com.Exo_Web.Exo.repository.ReviewRepository;
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
public class ReviewService {

    ReviewRepository reviewRepository;
    ReviewMapper reviewMapper;

    @Transactional
    public List<ReviewResponse> getAllReviews() {
        return reviewRepository.findAll().stream()
                .map(reviewMapper::toReviewResponse)
                .collect(Collectors.toList());
    }

    public ReviewResponse getReviewById(String reviewId) {
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        return reviewMapper.toReviewResponse(review);
    }

    public List<ReviewResponse> getBlogByType(String type) {
        List<Review> reviews = reviewRepository.findAllByType(type);
        if (reviews.isEmpty()) {
            throw new RuntimeException("No submenu found for type: " + type);
        }
        return reviews.stream()
                .map(reviewMapper::toReviewResponse)
                .collect(Collectors.toList());
    }

    public ReviewResponse createReview(ReviewCreationRequest request) {
        Review review = reviewMapper.toReview(request);
        review = reviewRepository.save(review);
        return reviewMapper.toReviewResponse(review);
    }

    public ReviewResponse updateReview(String id, ReviewUpdateRequest request) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        reviewMapper.updateReview(review, request);
        reviewRepository.save(review);
        return reviewMapper.toReviewResponse(review);
    }


    public void deleteReview(String id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        reviewRepository.delete(review);
    }
}
