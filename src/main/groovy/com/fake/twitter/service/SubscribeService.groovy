package com.fake.twitter.service

import com.fake.twitter.model.dto.UserDTO
import com.fake.twitter.model.dto.UserSubscriptionDTO

interface SubscribeService {

    Boolean subscribe(UserSubscriptionDTO userSubscription)

    Boolean unSubscribe(UserSubscriptionDTO userSubscription)

    Integer getCountSubscribers(String userId)

    List<UserDTO> getListSubscribers(String userId)
}