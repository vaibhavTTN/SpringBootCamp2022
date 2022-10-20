package com.RestFulWebServicePart1.RestFulWebServicePart1.Models;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

public class Employee {

    private  Integer id;
    @Size(min = 2,message = "Minimum 2 character are required")
    private  String name;
    @Min(value = 1,message = "Age must be greater than 1")
    @Max(value = 90,message = "Age must be less than 90")
    private  Integer age;

    public Employee(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
