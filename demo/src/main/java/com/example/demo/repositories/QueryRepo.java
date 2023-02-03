package com.example.demo.repositories;

import com.example.demo.r2dbcEntitys.QueryResult;
import lombok.RequiredArgsConstructor;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface QueryRepo extends R2dbcRepository<QueryResult,String> {

    @Query(value = "SELECT\n" +
            "    A.user_id,\n" +
            "    A.user_name,\n" +
            "    A.group_code,\n" +
            "    TG.group_name\n" +
            "\n" +
            "\n" +
            "\n" +
            "    FROM T_USER A\n" +
            "   JOIN T_GROUP TG on TG.group_code = A.group_code\n" +
            "WHERE user_id='ch.kim'")
    Mono<QueryResult> findByUserId();
}
