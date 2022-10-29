package com.SpringDataJPAwithHibernatePart2.InheritanceMapping.JoinedStrategy.Entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "permanentJoinedEmployee")
@PrimaryKeyJoinColumn(name = "id")
public class PermanentEmployeeJoinedStrategy extends EmployeeJoinedStrategy {
    private String designation;

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "permanent_employee{" +
                "destination='" + designation + '\'' +
                '}';
    }
}
