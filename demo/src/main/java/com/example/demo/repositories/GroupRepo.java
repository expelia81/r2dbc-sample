package com.example.demo.repositories;

import com.example.demo.r2dbcEntitys.GroupEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepo extends R2dbcRepository<GroupEntity,Integer> {
}
