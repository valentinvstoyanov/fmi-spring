package com.valentinvstoyanov.bloggerrestapi.service.reactive_impl;

import com.valentinvstoyanov.bloggerrestapi.dao.ReactiveUserRepository;
import com.valentinvstoyanov.bloggerrestapi.exception.NonExistingEntityException;
import com.valentinvstoyanov.bloggerrestapi.model.User;
import com.valentinvstoyanov.bloggerrestapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
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
    public Mono<User> delete(String userId) {
        return userRepository
                .findById(userId)
                .flatMap(user -> userRepository.delete(user).thenReturn(user))
                .switchIfEmpty(Mono.error(new NonExistingEntityException(String.format("Failed to delete user with id %s", userId))));
    }

    @Override
    public Mono<User> findById(String userId) {
        return userRepository.findById(userId)
                .switchIfEmpty(Mono.error(new NonExistingEntityException(String.format("Failed to find user with id %s", userId))));
    }
}
