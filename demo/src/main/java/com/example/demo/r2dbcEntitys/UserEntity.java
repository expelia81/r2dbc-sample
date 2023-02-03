package com.example.demo.r2dbcEntitys;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;

@Table("T_USER")
//@NoArgsConstructor
@AllArgsConstructor
//@AllArgsConstructor
//@Data
//@Setter
@Slf4j
public class UserEntity {

    public @Id String userId;
    private String userName;
    private GroupEntity group = new GroupEntity();





//    @PersistenceCreator
    static public UserEntity createObject(String userId, String userName, Integer groupCode, String groupName) {
        return new UserEntity(userId,userName,new GroupEntity(groupCode, groupName));
    }

    @PersistenceCreator
    public UserEntity(String userId, String userName, Integer groupCode, String groupName) {
        this.userId = userId;
        this.userName = userName;
        group = new GroupEntity(groupCode, groupName);
    }
}
