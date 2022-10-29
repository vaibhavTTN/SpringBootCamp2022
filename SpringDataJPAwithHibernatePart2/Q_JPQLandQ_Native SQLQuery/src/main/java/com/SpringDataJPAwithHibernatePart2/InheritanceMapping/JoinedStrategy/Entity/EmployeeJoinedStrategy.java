package com.SpringDataJPAwithHibernatePart2.InheritanceMapping.JoinedStrategy.Entity;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class EmployeeJoinedStrategy {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    @Size(min = 2)
    private String name;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
