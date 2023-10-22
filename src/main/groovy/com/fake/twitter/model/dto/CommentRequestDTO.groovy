package com.fake.twitter.model.dto

class CommentRequestDTO {

    private String postId
    private String text

    CommentRequestDTO() {
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
