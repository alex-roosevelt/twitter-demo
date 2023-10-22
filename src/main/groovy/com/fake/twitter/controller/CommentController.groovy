package com.fake.twitter.controller

import com.fake.twitter.model.dto.CommentRequestDTO
import com.fake.twitter.model.entity.CommentEntity
import com.fake.twitter.service.CommentService
import io.swagger.annotations.Api
import io.swagger.v3.oas.annotations.Operation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@Api(tags = "контролер коментар")
@RequestMapping("/api/v1/comment")
class CommentController {

    private final CommentService commentService

    CommentController(CommentService commentService) {
        this.commentService = commentService
    }

    // get comment
    @Operation(summary = "отримати коментар з id")
    @GetMapping("/get/{commentId}")
    ResponseEntity<CommentEntity> getComment(@PathVariable String commentId) {
        return ResponseEntity.ok(commentService.getComment(commentId))
    }

    // add comment
    @Operation(summary = "створити коментар")
    @PostMapping("/create")
    ResponseEntity<Void> createComment(@RequestBody CommentRequestDTO commentRequest) {
        return ResponseEntity.ok(commentService.addComment(commentRequest))
    }

    // delete comment
    @Operation(summary = "видалити коментар")
    @DeleteMapping("/delete/{commentId}")
    ResponseEntity<Void> deleteComment(@PathVariable String commentId) {
        return ResponseEntity.ok(commentService.deleteComment(commentId))
    }

    // get all comments under post
    @Operation(summary = "переглянути всі коментарі")
    @GetMapping("/{postId}")
    ResponseEntity<List<CommentEntity>> getAllComments(@PathVariable String postId) {
        return ResponseEntity.ok(commentService.getAllByPostId(postId))
    }
}
