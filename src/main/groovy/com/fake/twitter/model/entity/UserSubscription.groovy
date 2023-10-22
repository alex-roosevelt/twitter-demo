package com.fake.twitter.model.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
class UserSubscription {

    @Id
    private String id
    private String subId
    private String targetId

    UserSubscription() {
    }

    String getId() {
        return id
    }

    String getSubId() {
        return subId
    }

    void setSubId(String subId) {
        this.subId = subId
    }

    String getTargetId() {
        return targetId
    }

    void setTargetId(String targetId) {
        this.targetId = targetId
    }
}
