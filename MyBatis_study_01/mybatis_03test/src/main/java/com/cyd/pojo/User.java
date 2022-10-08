package com.cyd.pojo;

import org.apache.ibatis.type.Alias;

@Alias("User")
public class User {
    int id;
    String name;
    String password;
    public User(){}
    public User(int id,String name,String pwd){
        this.id = id;
        this.name = name;
        this.password = pwd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return password;
    }

    public void setPwd(String pwd) {
        this.password = pwd;
    }
}
