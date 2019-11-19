package com.valentinvstoyanov.bloggerrestapi.service;

import com.valentinvstoyanov.bloggerrestapi.model.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
    Flux<User> findAll();

    Mono<User> create(User user);

    Mono<User> update(User user);

    Mono<User> delete(String userId);

    Mono<User> findById(String userId);
}
