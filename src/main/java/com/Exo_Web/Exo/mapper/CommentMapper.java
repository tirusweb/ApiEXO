package com.Exo_Web.Exo.mapper;

import com.Exo_Web.Exo.dto.request.CommentCreationRequest;
import com.Exo_Web.Exo.dto.request.CommentUpdateRequest;
import com.Exo_Web.Exo.dto.response.CommentResponse;
import com.Exo_Web.Exo.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    @Mapping(target = "review", ignore = true)
    Comment toComment(CommentCreationRequest  comments);
    CommentResponse toCommentResponse(Comment comment);
    void updateComment(@MappingTarget Comment comment, CommentUpdateRequest request);
}
