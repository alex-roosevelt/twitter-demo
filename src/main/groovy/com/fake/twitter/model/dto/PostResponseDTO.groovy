package com.fake.twitter.model.dto

import java.time.LocalDateTime

class PostResponseDTO {
    private String id
    private String userId
    private String post
    private LocalDateTime createdPost
    private LocalDateTime editedPost

    PostResponseDTO() {

    }

    String getId() {
        return id
    }

    void setId(String id) {
        this.id = id
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
