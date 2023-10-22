package com.fake.twitter.model.dto

class UserSubscriptionDTO {

    private String subId
    private String targetId

    UserSubscriptionDTO() {
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
