package com.valentinvstoyanov.bloggerrestapi.service;

import com.valentinvstoyanov.bloggerrestapi.model.Post;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PostService {
    Flux<Post> findAll();

    Mono<Post> create(Post post);

    Mono<Post> update(Post post);

    Mono<Post> delete(String postId);

    Mono<Post> findById(String postId);
}
