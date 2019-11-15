package com.valentinvstoyanov.bloggerrestapi.dao;

import com.valentinvstoyanov.bloggerrestapi.model.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import java.util.UUID;

public interface ReactiveUserRepository extends ReactiveMongoRepository<User, UUID> {
}
