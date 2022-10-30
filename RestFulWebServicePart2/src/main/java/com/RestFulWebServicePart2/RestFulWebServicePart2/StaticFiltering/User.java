package com.RestFulWebServicePart2.RestFulWebServicePart2.StaticFiltering;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class User {
    private int id, age;
    private String name;

    @JsonIgnore
    private String password;

    public User(int id, int age, String name, String password){
        this.id = id;
        this.age = age;
        this.name = name;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
