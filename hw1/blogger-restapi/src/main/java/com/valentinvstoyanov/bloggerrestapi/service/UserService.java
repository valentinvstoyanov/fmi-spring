package com.valentinvstoyanov.bloggerrestapi.service;

import com.valentinvstoyanov.bloggerrestapi.model.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface UserService {
    Flux<User> findAll();

    Mono<User> create(User article);

    Mono<User> update(User article);

    Mono<User> delete(UUID userId);

    Mono<User> findById(UUID userId);
}
