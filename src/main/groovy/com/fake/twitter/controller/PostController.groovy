package com.fake.twitter.controller

import com.fake.twitter.model.dto.FavoritePostRequestDTO
import com.fake.twitter.model.dto.PostDTO
import com.fake.twitter.model.dto.PostResponseDTO
import com.fake.twitter.service.PostService
import io.swagger.annotations.Api
import io.swagger.v3.oas.annotations.Operation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@Api(tags = "контролер постів")
@RequestMapping("/api/v1/post")
class PostController {

    private final PostService postService

    PostController(PostService postService) {
        this.postService = postService
    }

    // create post
    @Operation(summary = "створення посту")
    @PostMapping
    ResponseEntity<PostResponseDTO> createPost(@RequestBody PostDTO postRequestDto) {
        return ResponseEntity.ok(postService.createPost(postRequestDto))
    }

    // update post
    @Operation(summary = "оновлення посту")
    @PutMapping("/update/{postId}")
    ResponseEntity<PostResponseDTO> updatePost(@PathVariable String postId, @RequestBody PostDTO postRequestDto) {
        return ResponseEntity.ok(postService.updatePost(postId, postRequestDto))
    }

    // get post
    @Operation(summary = "отримання поста за id")
    @GetMapping("/{postId}")
    ResponseEntity<PostResponseDTO> getPost(@PathVariable String postId) {
        return ResponseEntity.ok(postService.getPostById(postId))
    }

    // get list post
    @Operation(summary = "отримання всіх постів")
    @GetMapping("/list")
    ResponseEntity<List<PostResponseDTO>> getList() {
        return ResponseEntity.ok(postService.getListPosts())
    }

    // delete post
    @Operation(summary = "видалення посту")
    @DeleteMapping("/delete/{postId}")
    ResponseEntity<Void> deletePost(@PathVariable String postId) {
        return ResponseEntity.ok(postService.deletePost(postId))
    }

    // add favorite post
    @Operation(summary = "додавання кращого посту")
    @PostMapping("/add-favorite")
    ResponseEntity<Void> addFavoritePost(@RequestBody FavoritePostRequestDTO favoritePostRequest){
        return ResponseEntity.ok(postService.addFavoritePost(favoritePostRequest))
    }


    // remove favorite post
    @Operation(summary = "видалення кращого посту")
    @DeleteMapping("/remove-favorite/{favoritePostId}")
    ResponseEntity<Void> removeFavoritePost(@PathVariable String favoritePostId){
        return ResponseEntity.ok(postService.removeFavoritePost(favoritePostId))
    }

}
