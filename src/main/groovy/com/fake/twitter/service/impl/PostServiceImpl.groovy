package com.fake.twitter.service.impl

import com.fake.twitter.mapper.PostMapper
import com.fake.twitter.model.dto.FavoritePostRequestDTO
import com.fake.twitter.model.dto.PostDTO
import com.fake.twitter.model.dto.PostResponseDTO
import com.fake.twitter.model.entity.FavoritePostEntity
import com.fake.twitter.model.entity.PostEntity
import com.fake.twitter.repository.FavoritePostRepository
import com.fake.twitter.repository.PostRepository
import com.fake.twitter.service.PostService
import org.springframework.stereotype.Service

import java.time.LocalDateTime

@Service
class PostServiceImpl implements PostService {

    private final PostRepository postRepository
    private final FavoritePostRepository favoritePostRepository
    private final PostMapper postMapper

    PostServiceImpl(PostRepository postRepository,
                    PostMapper postMapper,
                    FavoritePostRepository favoritePostRepository) {
        this.postRepository = postRepository
        this.postMapper = postMapper
        this.favoritePostRepository = favoritePostRepository
    }

    @Override
    PostResponseDTO createPost(PostDTO postRequestDto) {
        PostEntity postEntity = new PostEntity()
        postEntity.userId = postRequestDto.userId
        postEntity.post = postRequestDto.text
        postEntity.createdPost = LocalDateTime.now()

        return postMapper.mapToResponseDto(postRepository.save(postEntity))
    }

    @Override
    PostResponseDTO updatePost(String postId, PostDTO postRequestDto) {
        Optional<PostEntity> postEntity = postRepository.findById(postId)
        if (postEntity.isEmpty()) {
            return null
        } else {
            postEntity.get().userId = postRequestDto.userId
            postEntity.get().post = postRequestDto.text
            postEntity.get().editedPost = LocalDateTime.now()
            return postMapper.mapToResponseDto(postRepository.save(postEntity.get()))
        }
    }

    @Override
    PostResponseDTO getPostById(String postId) {
        PostEntity postEntity = postRepository.findById(postId).orElse(null)
        if (postEntity != null) {
            return postMapper.mapToResponseDto(postEntity)
        }
        return null
    }

    @Override
    List<PostResponseDTO> getListPosts(String userId) {
        return postRepository.findAllByUserId(userId)
                .stream()
                .map {it -> postMapper.mapToResponseDto(it)}
                .collect()
    }

    @Override
    void deletePost(String postId) {
        postRepository.deleteById(postId)
    }

    @Override
    void addFavoritePost(FavoritePostRequestDTO favoritePostRequest) {
        FavoritePostEntity favoritePost = new FavoritePostEntity()
        favoritePost.userId = favoritePostRequest.userId
        favoritePost.postId = favoritePostRequest.postId
        favoritePostRepository.save(favoritePost)
    }

    @Override
    void removeFavoritePost(String favoritePostId) {
        favoritePostRepository.deleteById(favoritePostId)
    }
}
