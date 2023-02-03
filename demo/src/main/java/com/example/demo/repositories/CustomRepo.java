package com.example.demo.repositories;

import com.example.demo.r2dbcEntitys.UserEntity;
import reactor.core.publisher.Mono;

public interface CustomRepo {
    Mono<UserEntity> findByUserId(String userId);

}
