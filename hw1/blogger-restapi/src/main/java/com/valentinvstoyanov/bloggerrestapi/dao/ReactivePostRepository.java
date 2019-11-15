package com.valentinvstoyanov.bloggerrestapi.dao;

import com.valentinvstoyanov.bloggerrestapi.model.Post;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import java.util.UUID;

public interface ReactivePostRepository extends ReactiveMongoRepository<Post, UUID> {
}
