package com.SpringDataJPAwithHibernatePart2.InheritanceMapping.SingleTableStrategy.Entity;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "employeeType",discriminatorType = DiscriminatorType.STRING)
public abstract class EmployeeSingleTableStrategy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
