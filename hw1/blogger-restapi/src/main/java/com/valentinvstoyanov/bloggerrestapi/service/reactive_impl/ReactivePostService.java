package com.valentinvstoyanov.bloggerrestapi.service.reactive_impl;

import com.valentinvstoyanov.bloggerrestapi.dao.ReactivePostRepository;
import com.valentinvstoyanov.bloggerrestapi.model.Post;
import com.valentinvstoyanov.bloggerrestapi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public class ReactivePostService implements PostService {
    @Autowired
    private ReactivePostRepository postRepository;

    @Override
    public Flux<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Mono<Post> create(Post post) {
        return postRepository.insert(post);
    }

    @Override
    public Mono<Post> update(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Mono<Post> delete(UUID postId) {
        return postRepository.findById(postId).flatMap(post -> postRepository.delete(post).thenReturn(post));
    }

    @Override
    public Mono<Post> findById(UUID postId) {
        return postRepository.findById(postId);
    }
}
