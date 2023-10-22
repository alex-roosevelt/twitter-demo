package com.fake.twitter.model.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

import java.time.LocalDateTime

@Document
class PostEntity {

    @Id
    private String id
    private String userId
    private String post
    private LocalDateTime createdPost
    private LocalDateTime editedPost

    PostEntity() {
    }

    String getId() {
        return id
    }

    String getUserId() {
        return userId
    }

    void setUserId(String userId) {
        this.userId = userId
    }

    String getPost() {
        return post
    }

    void setPost(String post) {
        this.post = post
    }

    LocalDateTime getCreatedPost() {
        return createdPost
    }

    void setCreatedPost(LocalDateTime createdPost) {
        this.createdPost = createdPost
    }

    LocalDateTime getEditedPost() {
        return editedPost
    }

    void setEditedPost(LocalDateTime editedPost) {
        this.editedPost = editedPost
    }
}
