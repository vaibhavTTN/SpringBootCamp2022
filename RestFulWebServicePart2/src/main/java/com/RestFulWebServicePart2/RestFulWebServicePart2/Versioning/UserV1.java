package com.RestFulWebServicePart2.RestFulWebServicePart2.Versioning;

public class UserV1 {
    private int id,age;
    private String name;

    public UserV1(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
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

    @Override
    public String toString(){
        return "User Details :- " + "ID : "+this.id+ ", Name : "+this.name+", Age : "+this.age;
    }
}
