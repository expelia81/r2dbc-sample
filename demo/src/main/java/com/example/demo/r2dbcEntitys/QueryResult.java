package com.example.demo.r2dbcEntitys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QueryResult {
    private String userId;
    private String userName;
    private Integer groupCode;
    private String groupName;

}
