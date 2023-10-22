package com.fake.twitter.model.dto

class FavoritePostRequestDTO {
    private String userId
    private String postId

    FavoritePostRequestDTO() {

    }

    String getUserId() {
        return userId
    }

    void setUserId(String userId) {
        this.userId = userId
    }

    String getPostId() {
        return postId
    }

    void setPostId(String postId) {
        this.postId = postId
    }
}
