package com.fake.twitter.service.impl

import com.fake.twitter.mapper.UserMapper
import com.fake.twitter.model.dto.UserDTO
import com.fake.twitter.model.dto.UserSubscriptionDTO
import com.fake.twitter.model.entity.UserSubscription
import com.fake.twitter.repository.UserRepository
import com.fake.twitter.repository.UserSubscribeRepository
import com.fake.twitter.service.SubscribeService
import org.springframework.stereotype.Service

@Service
class SubscribeServiceImpl implements SubscribeService {

    private final UserSubscribeRepository userSubscribeRepository
    private final UserRepository userRepository
    private final UserMapper userMapper

    SubscribeServiceImpl(UserSubscribeRepository userSubscribeRepository,
                         UserRepository userRepository,
                         UserMapper userMapper) {
        this.userSubscribeRepository = userSubscribeRepository
        this.userRepository = userRepository
        this.userMapper = userMapper
    }

    @Override
    Boolean subscribe(UserSubscriptionDTO request) {

        UserSubscription userSubscription = new UserSubscription()
        userSubscription.subId = request.subId
        userSubscription.targetId = request.targetId
        var entity = userSubscribeRepository.save(userSubscription)
        return entity != null
    }

    @Override
    Boolean unSubscribe(UserSubscriptionDTO request) {
        var entity = userSubscribeRepository
                .findBySubIdAndTargetId(request.subId, request.targetId)
        if (entity.isPresent()) {
            userSubscribeRepository.deleteById(entity.get().id)
            return true
        }
        return false
    }

    @Override
    Integer getCountSubscribers(String userId) {
        return userSubscribeRepository.findAllBySubId(userId).stream().count()
    }

    @Override
    List<UserDTO> getListSubscribers(String userId) {
        List<String> listTargetIds = userSubscribeRepository.findAllBySubId(userId)
                .stream()
                .map { it -> it.targetId }
                .collect()

        if (!listTargetIds.isEmpty()) {
            return userRepository.findByIdIn(listTargetIds)
                    .stream()
                    .map { it -> userMapper.userMapToDto(it) }
                    .collect()
        }
        return null
    }
}
