package com.fake.twitter.service

import com.fake.twitter.model.dto.CommentRequestDTO
import com.fake.twitter.model.entity.CommentEntity

interface CommentService {

    void addComment(CommentRequestDTO commentRequest)

    CommentEntity getComment(String commentId)

    List<CommentEntity> getAllByPostId(String postId)

    void deleteComment(String commentId)
}