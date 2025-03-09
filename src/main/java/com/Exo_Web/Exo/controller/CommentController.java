package com.Exo_Web.Exo.controller;


import com.Exo_Web.Exo.dto.request.*;
import com.Exo_Web.Exo.dto.response.CommentResponse;
import com.Exo_Web.Exo.dto.response.SkillResponse;
import com.Exo_Web.Exo.service.CommentService;
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
@RequestMapping("/comments")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE , makeFinal = true)
@CrossOrigin(origins = "*")
public class CommentController {
    CommentService commentService;

    @PostMapping
    public ApiResponse<CommentResponse> createComment(@RequestBody @Valid CommentCreationRequest request){
        ApiResponse<CommentResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(commentService.createComment(request));
        return apiResponse;
    }

    @GetMapping
    public ApiResponse<List<CommentResponse>> getAllComments() {
        ApiResponse<List<CommentResponse>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(commentService.getAllComment());
        return apiResponse;
    }

    @GetMapping("/{id}")
    public ApiResponse<CommentResponse> getCommentById(@PathVariable String id) {
        return new ApiResponse<>(commentService.getCommentById(id));
    }


    @PutMapping("/{id}")
    public ApiResponse<CommentResponse> updateComment(@PathVariable String id , @RequestBody @Valid CommentUpdateRequest request) {
        ApiResponse<CommentResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(commentService.updateComment(id, request));
        return apiResponse;
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteComment(@PathVariable String id) {
        commentService.deleteComment(id);
        ApiResponse<String> apiResponse = new ApiResponse<>();
        apiResponse.setResult("success");
        return apiResponse;
    }

}
