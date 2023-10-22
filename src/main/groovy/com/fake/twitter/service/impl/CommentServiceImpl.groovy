package com.fake.twitter.service.impl

import com.fake.twitter.model.dto.CommentRequestDTO
import com.fake.twitter.model.entity.CommentEntity
import com.fake.twitter.repository.CommentRepository
import com.fake.twitter.service.CommentService
import org.springframework.stereotype.Service

@Service
class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository

    CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository
    }

    @Override
    void addComment(CommentRequestDTO commentRequest) {
        CommentEntity comment = new CommentEntity()
        comment.postId = commentRequest.postId
        comment.text = commentRequest.text
        commentRepository.save(comment)
    }

    @Override
    CommentEntity getComment(String commentId) {
        return commentRepository.findById(commentId).orElse(null)
    }

    @Override
    List<CommentEntity> getAllByPostId(String postId) {
        return commentRepository.findAllByPostId(postId)
    }

    @Override
    void deleteComment(String commentId) {
        Optional<CommentEntity> comment = commentRepository.findById(commentId)
        if (comment.isPresent()) {
            commentRepository.deleteById(commentId)
        }
    }
}
