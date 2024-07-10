package com.bronyst.spring_reactive.posts.service;

import com.bronyst.spring_reactive.posts.dto.PostDto;
import com.bronyst.spring_reactive.posts.entities.Post;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PostsService {
    Flux<Post> findAll();

    Mono<Post> findById(Long id);

    Mono<Post> save(PostDto post);

    Mono<Void> deleteById(Long id);
}
