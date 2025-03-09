package com.Exo_Web.Exo.service;

import com.Exo_Web.Exo.dto.request.CommentCreationRequest;
import com.Exo_Web.Exo.dto.request.CommentUpdateRequest;
import com.Exo_Web.Exo.dto.request.SkillCreationRequest;
import com.Exo_Web.Exo.dto.request.SkillUpdateRequest;
import com.Exo_Web.Exo.dto.response.CommentResponse;
import com.Exo_Web.Exo.dto.response.SkillResponse;
import com.Exo_Web.Exo.entity.Comment;
import com.Exo_Web.Exo.entity.Employee;
import com.Exo_Web.Exo.entity.Review;
import com.Exo_Web.Exo.entity.Skill;
import com.Exo_Web.Exo.mapper.CommentMapper;
import com.Exo_Web.Exo.mapper.SkillMapper;
import com.Exo_Web.Exo.repository.CommentRepository;
import com.Exo_Web.Exo.repository.EmployeeRepository;
import com.Exo_Web.Exo.repository.ReviewRepository;
import com.Exo_Web.Exo.repository.SkillRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CommentService {
    CommentRepository commentRepository;
    CommentMapper commentMapper;
    ReviewRepository reviewRepository;

    public CommentResponse createComment(CommentCreationRequest request) {
        // 🔍 Kiểm tra Employee có tồn tại không
        Review review = reviewRepository.findById(request.getReviewId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        // 🔄 Map request sang Skill entity
        Comment comment = commentMapper.toComment(request);
        comment.setReview(review);
        // 💾 Lưu vào DB
        comment = commentRepository.save(comment);

        return commentMapper.toCommentResponse(comment);
    }

    public List<CommentResponse> getAllComment() {
        return commentRepository.findAll().stream()
                .map(commentMapper::toCommentResponse)
                .collect(Collectors.toList());
    }

    // 🔍 Lấy Skill theo ID
    public CommentResponse getCommentById(String commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("Skill not found"));
        return commentMapper.toCommentResponse(comment);
    }

    public CommentResponse updateComment(String commentId, CommentUpdateRequest request) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("Skill not found"));

        comment.setName(request.getName());
        comment.setContentCmt(request.getContentCmt());
        comment.setUpdatedAt(request.getUpdatedAt());

        commentRepository.save(comment);
        return commentMapper.toCommentResponse(comment);
    }

    public void deleteComment(String commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("Skill not found"));
        commentRepository.delete(comment);
    }
}
