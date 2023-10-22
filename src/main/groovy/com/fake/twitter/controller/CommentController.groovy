package com.fake.twitter.controller

import com.fake.twitter.model.dto.CommentRequestDTO
import com.fake.twitter.model.entity.CommentEntity
import com.fake.twitter.service.CommentService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/v1/comment")
class CommentController {

    private final CommentService commentService

    CommentController(CommentService commentService) {
        this.commentService = commentService
    }

    // get comment
    @GetMapping("/get/{commentId}")
    ResponseEntity<CommentEntity> getComment(@PathVariable String commentId) {
        return ResponseEntity.ok(commentService.getComment(commentId))
    }

    // add comment
    @PostMapping("/create")
    ResponseEntity<Void> createComment(@RequestBody CommentRequestDTO commentRequest) {
        return ResponseEntity.ok(commentService.addComment(commentRequest))
    }

    // delete comment
    @DeleteMapping("/delete/{commentId}")
    ResponseEntity<Void> deleteComment(@PathVariable String commentId) {
        return ResponseEntity.ok(commentService.deleteComment(commentId))
    }

    // get all comments under post
    @GetMapping("/{postId}")
    ResponseEntity<List<CommentEntity>> getAllComments(@PathVariable String postId) {
        return ResponseEntity.ok(commentService.getAllByPostId(postId))
    }
}
