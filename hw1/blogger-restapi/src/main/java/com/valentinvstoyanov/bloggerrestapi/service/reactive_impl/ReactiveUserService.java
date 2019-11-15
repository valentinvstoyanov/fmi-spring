package com.valentinvstoyanov.bloggerrestapi.service.reactive_impl;

import com.valentinvstoyanov.bloggerrestapi.dao.ReactiveUserRepository;
import com.valentinvstoyanov.bloggerrestapi.model.User;
import com.valentinvstoyanov.bloggerrestapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public class ReactiveUserService implements UserService {
    @Autowired
    private ReactiveUserRepository userRepository;

    @Override
    public Flux<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Mono<User> create(User user) {
        return userRepository.insert(user);
    }

    @Override
    public Mono<User> update(User user) {
        return userRepository.save(user);
    }

    @Override
    public Mono<User> delete(UUID userId) {
        return userRepository.findById(userId).flatMap(user -> userRepository.delete(user).thenReturn(user));
    }

    @Override
    public Mono<User> findById(UUID userId) {
        return userRepository.findById(userId);
    }
}
