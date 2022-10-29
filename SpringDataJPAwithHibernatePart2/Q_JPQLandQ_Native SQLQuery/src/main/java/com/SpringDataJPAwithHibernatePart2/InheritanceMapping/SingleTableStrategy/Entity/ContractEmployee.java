package com.SpringDataJPAwithHibernatePart2.InheritanceMapping.SingleTableStrategy.Entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "contract")
public class ContractEmployee extends EmployeeSingleTableStrategy{
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
