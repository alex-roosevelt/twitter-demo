package com.fake.twitter.repository

import com.fake.twitter.model.entity.UserSubscription
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UserSubscribeRepository extends MongoRepository<UserSubscription, String> {

    Optional<UserSubscription> findBySubIdAndTargetId(String subId, String targetId)
    List<UserSubscription> findAllBySubId(String subId)
}
