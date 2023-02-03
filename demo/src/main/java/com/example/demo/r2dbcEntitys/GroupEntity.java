package com.example.demo.r2dbcEntitys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "T_GROUP")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupEntity {
    public @Id Integer groupCode;
    public String groupName;

}
