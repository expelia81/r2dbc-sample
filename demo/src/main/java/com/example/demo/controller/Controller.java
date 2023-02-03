package com.example.demo.controller;

import com.example.demo.r2dbcEntitys.GroupEntity;
import com.example.demo.r2dbcEntitys.QueryResult;
import com.example.demo.r2dbcEntitys.UserEntity;
import com.example.demo.repositories.GroupRepo;
import com.example.demo.repositories.QueryRepo;
import com.example.demo.repositories.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.relational.core.query.Query;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final GroupRepo groupRepo;
    private final UserRepo userRepo;

    private final QueryRepo queryRepo;

    private final R2dbcEntityTemplate template;


    @GetMapping("group")
    public Mono<GroupEntity> groupRequestHandler(){

        return Mono.just(1)
                .flatMap(integer -> groupRepo.findById(integer));
    }

    @GetMapping("user")
    public Mono<UserEntity> userRequestHandler(){

        return Mono.just(1)
                .flatMap(integer -> userRepo.findById("ch.kim"));
    }

    @GetMapping("result")
    public Mono<QueryResult> resultRequestHandler(){

        return Mono.just(1)
                .flatMap(integer -> queryRepo.findByUserId());
    }

    /**
     * 직접 이너조인 생성.
     * 희망결과 : UserEntity의 Group에도 값이 자동으로 매핑됨
     * (아마도)현실 : UserEntity 변수들에는 매핑되나, Group내부는 매핑불가능. null로 매핑.
     */
    @GetMapping("object")
    public Mono<UserEntity> testRequestHandler(){
        return Mono.just(1)
                .flatMap(integer -> userRepo.findByUserId33());
    }

//    @GetMapping("QueryDSL")
//    public Mono<UserEntity> queryDSLRequestHandler(){
//
//        return Mono.just(1)
//                .flatMap(integer -> queryDSLRepo.query(sqlQuery ->
//                        sqlQuery.select(queryDSLRepo.entityProjection())
//                                .from()
//                                .innerJoin()
//                        ));
//    }

    public Mono<UserEntity> templateTest(){



        return null;
    }
}
