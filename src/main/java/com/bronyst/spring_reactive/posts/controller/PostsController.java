package com.bronyst.spring_reactive.posts.controller;

import com.bronyst.spring_reactive.posts.dto.PostDto;
import com.bronyst.spring_reactive.posts.entities.Post;
import com.bronyst.spring_reactive.posts.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/posts")
public class PostsController {
    @Autowired
    private PostsService postsService;

    @GetMapping
    public Flux<Post> getAllPosts() {
        return postsService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Post> getPostById(@PathVariable Long id) {
        return postsService.findById(id);
    }

    @PostMapping()
    public Mono<Post> createPost(
            @RequestBody PostDto post
    ) {
        return postsService.save(post);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deletePost(@PathVariable Long id) {
        return postsService.deleteById(id);
    }


}
