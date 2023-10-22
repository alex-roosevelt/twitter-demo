package com.fake.twitter.model.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
class FavoritePostEntity {

    @Id
    private String id
    private String userId
    private String postId

    FavoritePostEntity() {
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

    String getPostId() {
        return postId
    }

    void setPostId(String postId) {
        this.postId = postId
    }
}
