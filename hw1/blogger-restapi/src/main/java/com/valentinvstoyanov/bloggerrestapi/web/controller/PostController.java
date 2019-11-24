package com.valentinvstoyanov.bloggerrestapi.web.controller;

import com.valentinvstoyanov.bloggerrestapi.exception.IllegalEntityBodyException;
import com.valentinvstoyanov.bloggerrestapi.model.Post;
import com.valentinvstoyanov.bloggerrestapi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping
    Flux<Post> findAll() {
        return postService.findAll();
    }

    @PostMapping
    Mono<ResponseEntity<Post>> create(@RequestBody Post post, UriComponentsBuilder uriComponentsBuilder) {
        return postService.create(post)
                .map(p -> ResponseEntity.created(uriComponentsBuilder.path("/api/posts/{id}").buildAndExpand(p.getId()).toUri()).body(p));
    }

    @PutMapping("/{id}")
    Mono<Post> update(@PathVariable("id") String postId, @RequestBody Post post) throws IllegalEntityBodyException {
        if (!postId.equals(post.getId())) {
            throw new IllegalEntityBodyException(String.format("Post body id: %s differs from path id %s", post.getId(), postId));
        }

        return postService.update(post);
    }

    @DeleteMapping("/{id}")
    Mono<Post> delete(@PathVariable("id") String postId) {
        return postService.delete(postId);
    }

    @GetMapping("/{id}")
    Mono<Post> findById(@PathVariable("id") String postId) {
        return postService.findById(postId);
    }
}
