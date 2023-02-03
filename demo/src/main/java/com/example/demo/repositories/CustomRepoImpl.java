package com.example.demo.repositories;

import com.example.demo.r2dbcEntitys.UserEntity;
import io.r2dbc.spi.Row;
import lombok.RequiredArgsConstructor;
import org.springframework.r2dbc.core.DatabaseClient;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CustomRepoImpl implements CustomRepo{

    private final DatabaseClient databaseClient;

    @Override
    public Mono<UserEntity> findByUserId(String userId) {
        String query = "SELECT\n" +
                "    A.user_id,\n" +
                "    A.user_name,\n" +
                "    A.group_code,\n" +
                "    TG.group_name\n" +
                "\n" +
                "\n" +
                "\n" +
                "    FROM T_USER A\n" +
                "   JOIN T_GROUP TG on TG.group_code = A.group_code\n" +
                "WHERE user_id='ch.kim'";
        databaseClient.sql(query)
                .bind("userId",userId);
        Row row;

        return null;
    }
}
