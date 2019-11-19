package com.valentinvstoyanov.bloggerrestapi.dao;

import com.valentinvstoyanov.bloggerrestapi.model.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ReactiveUserRepository extends ReactiveMongoRepository<User, String> {
}
