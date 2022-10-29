package com.SpringDataJPAwithHibernatePart2.JPQLandNativeSQLQuery.Entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "employeeTable")
public class Employee {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long empId;

    @NotNull
    @Size(min = 2)
    @Column(name = "firstName")
    private String empFirstName;

    @NotNull
    @Size(min = 2)
    @Column(name = "lastName")
    private String empLastName;

    @NotNull
    @Min(9999)
    @Column(name = "salary")
    private Double empSalary;

    @NotNull
    @Min(20)
    @Max(80)
    @Column(name = "age")
    private Integer empAge;

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getEmpFirstName() {
        return empFirstName;
    }

    public void setEmpFirstName(String empFirstName) {
        this.empFirstName = empFirstName;
    }

    public String getEmpLastName() {
        return empLastName;
    }

    public void setEmpLastName(String empLastName) {
        this.empLastName = empLastName;
    }

    public Double getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(Double empSalary) {
        this.empSalary = empSalary;
    }

    public Integer getEmpAge() {
        return empAge;
    }

    public void setEmpAge(Integer empAge) {
        this.empAge = empAge;
    }
}
