package com.RestFulWebServicePart2.RestFulWebServicePart2.DynamicFiltering;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("dynamicFilter")
public class DynamicUser {
    private int id, salary;
    private String name, password;

    public DynamicUser(int id, int salary, String name, String password) {
        this.id = id;
        this.salary = salary;
        this.name = name;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
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
