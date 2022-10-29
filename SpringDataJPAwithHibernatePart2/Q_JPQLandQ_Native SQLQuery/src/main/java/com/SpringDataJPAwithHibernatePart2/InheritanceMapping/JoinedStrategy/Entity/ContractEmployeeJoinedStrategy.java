package com.SpringDataJPAwithHibernatePart2.InheritanceMapping.JoinedStrategy.Entity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "contractJoinedEmployee")
@Inheritance(strategy = InheritanceType.JOINED)
public class ContractEmployeeJoinedStrategy extends EmployeeJoinedStrategy {
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
