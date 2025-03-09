package com.Exo_Web.Exo.mapper;


import com.Exo_Web.Exo.dto.request.*;
import com.Exo_Web.Exo.dto.response.CommentResponse;
import com.Exo_Web.Exo.dto.response.ReviewResponse;
import com.Exo_Web.Exo.entity.Comment;
import com.Exo_Web.Exo.entity.Review;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface ReviewMapper {
    Review toReview(ReviewCreationRequest request);
    ReviewResponse toReviewResponse(Review review);
    CommentResponse toCommentResponse(Comment comment);
   @Mapping(target = "createdAt" , ignore = true)
    void updateReview(@MappingTarget Review review , ReviewUpdateRequest request);

}
