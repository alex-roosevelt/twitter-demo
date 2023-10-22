package com.fake.twitter.model.dto

import com.fasterxml.jackson.annotation.JsonProperty

class PostDTO {

    @JsonProperty("user_id")
    private String userId
    private String text

    PostDTO() {
    }

    String getUserId() {
        return userId
    }

    void setUserId(String userId) {
        this.userId = userId
    }

    String getText() {
        return text
    }

    void setText(String text) {
        this.text = text
    }
}
