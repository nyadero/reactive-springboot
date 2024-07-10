package com.bronyst.spring_reactive.posts.serviceimpl;

import com.bronyst.spring_reactive.posts.dto.PostDto;
import com.bronyst.spring_reactive.posts.entities.Post;
import com.bronyst.spring_reactive.posts.repository.PostsRepository;
import com.bronyst.spring_reactive.posts.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PostsServiceImpl implements PostsService {
    @Autowired
    private PostsRepository postsRepository;

    @Override
    public Flux<Post> findAll() {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        return postsRepository.findAll(sort);
    }

    @Override
    public Mono<Post> findById(Long id) {
        return postsRepository.findById(id);
    }

    @Override
    public Mono<Post> save(PostDto post) {
        Post post1 = new Post();
        return postsRepository.save(post1);
    }

    @Override
    public Mono<Void> deleteById(Long id) {
        return postsRepository.deleteById(id);
    }
}
