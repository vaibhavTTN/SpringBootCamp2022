package com.SpringDataJPAwithHibernatePart2.InheritanceMapping.TablePerClassStrategy.Entity;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class EmployeeTablePerClassStrategy {
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
