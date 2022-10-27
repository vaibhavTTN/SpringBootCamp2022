package com.SpringDataJPAwithHibernatePart1.SpringDataJPAwithHibernatePart1.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/*
    Q1 . Create an Employee Entity which contains following fields
        Name
        Id
        Age
        Location
 */

@Entity
public class Employees {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "Name cannot be null")
    @Size(min = 2)
    private String name;
    @NotNull(message = "age cannot be null")
    @Min(value = 5)
    @Max(value = 70)
    private Integer age;
    @NotNull(message = "location cannot be null")
    @Size(min=2)
    private String location;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getLocation() {
        return location;
    }
}
