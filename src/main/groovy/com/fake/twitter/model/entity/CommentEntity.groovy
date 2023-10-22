package com.fake.twitter.model.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
class CommentEntity {
    @Id
    private String id;
    private String postId; // Идентификатор поста, к которому относится комментарий
    private String text;

    CommentEntity() {
    }

    String getId() {
        return id
    }

    String getPostId() {
        return postId
    }

    void setPostId(String postId) {
        this.postId = postId
    }

    String getText() {
        return text
    }

    void setText(String text) {
        this.text = text
    }
}
