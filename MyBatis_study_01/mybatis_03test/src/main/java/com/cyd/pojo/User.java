package com.cyd.pojo;

import lombok.*;
import org.apache.ibatis.type.Alias;

@Alias("User")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class User {
    int id;
    String name;
    String password;
}
