package com.bronyst.spring_reactive.posts.controller;

import com.bronyst.spring_reactive.posts.dto.PostDto;
import com.bronyst.spring_reactive.posts.entities.Post;
import com.bronyst.spring_reactive.posts.service.PostsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;

@WebFluxTest(PostsController.class)
class PostsControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private PostsService postsService;

    private Post samplePost;
    private PostDto samplePostDto;

    @BeforeEach
    void setUp() {
        samplePost = new Post(1L, "Title", "Content");
        samplePostDto = new PostDto("Title", "Content");

        given(postsService.findAll()).willReturn(Flux.just(samplePost));
        given(postsService.findById(anyLong())).willReturn(Mono.just(samplePost));
        given(postsService.save(any(PostDto.class))).willReturn(Mono.just(samplePost));
        given(postsService.deleteById(anyLong())).willReturn(Mono.empty());
    }

    @Test
    void getAllPosts() {
        webTestClient.get().uri("/api/v1/posts")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBodyList(Post.class)
                .hasSize(1)
                .contains(samplePost);
    }

    @Test
    void getPostById() {
        webTestClient.get().uri("/api/v1/posts/{id}", 1L)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody(Post.class)
                .isEqualTo(samplePost);
    }

    @Test
    void createPost() {
        webTestClient.post().uri("/api/v1/posts")
                .bodyValue(samplePostDto)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody(Post.class)
                .isEqualTo(samplePost);
    }

    @Test
    void deletePost() {
        webTestClient.delete().uri("/api/v1/posts/{id}", 1L)
                .exchange()
                .expectStatus().isOk();
    }
}
