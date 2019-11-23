package com.valentinvstoyanov.bloggerrestapi.web.controller;

import com.valentinvstoyanov.bloggerrestapi.exception.IllegalEntityBodyException;
import com.valentinvstoyanov.bloggerrestapi.model.User;
import com.valentinvstoyanov.bloggerrestapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    Flux<User> findAll() {
        return userService.findAll();
    }

    @PostMapping
    Mono<User> create(@RequestBody User user) {
        return userService.create(user);
    }

    @PutMapping("/{id}")
    Mono<User> update(@PathVariable("id") String userId, @RequestBody User user) throws IllegalEntityBodyException {
        if (!userId.equals(user.getId())) {
            throw new IllegalEntityBodyException(String.format("User body id: %s differs from path id %s", user.getId(), userId));
        }

        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    Mono<User> delete(@PathVariable("id") String userId) {
        return userService.delete(userId);
    }

    @GetMapping("/{id}")
    Mono<User> findById(@PathVariable("id") String userId) {
        return userService.findById(userId);
    }
}
