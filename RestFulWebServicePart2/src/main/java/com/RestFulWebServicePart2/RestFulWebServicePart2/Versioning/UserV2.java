package com.RestFulWebServicePart2.RestFulWebServicePart2.Versioning;

public class UserV2 {
    private int id, age, salary;
    private String name, designation, city;

    public UserV2(int id, int age, int salary, String name, String designation, String city) {
        this.id = id;
        this.age = age;
        this.salary = salary;
        this.name = name;
        this.designation = designation;
        this.city = city;
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

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString(){
        return "Enhanced User Details :- ID : "+this.id+ ", Name : "+this.name+", Age : "+this.age+", Salary : "+this.salary+", Designation : "+this.designation+", City : "+this.city;
    }
}
