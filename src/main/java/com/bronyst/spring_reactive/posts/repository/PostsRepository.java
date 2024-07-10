package com.bronyst.spring_reactive.posts.repository;

import com.bronyst.spring_reactive.posts.entities.Post;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface PostsRepository extends ReactiveCrudRepository<Post, Long> {
    Flux<Post> findAll(Sort sort);
}