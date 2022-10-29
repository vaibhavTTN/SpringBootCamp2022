package com.SpringDataJPAwithHibernatePart2.InheritanceMapping.TablePerClassStrategy.Entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "contractEmployee")
public class ContractEmployeeTablePerClassStrategy extends EmployeeTablePerClassStrategy {
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
