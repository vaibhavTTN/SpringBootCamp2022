package com.SpringDataJPAwithHibernatePart1.SpringDataJPAwithHibernatePart1.Repository;

import com.SpringDataJPAwithHibernatePart1.SpringDataJPAwithHibernatePart1.Entity.Employees;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
/*
        Q.2 Set up EmployeeRepository with Spring Data JPA
 */

public interface EmployeeRepository extends PagingAndSortingRepository<Employees,Integer>{
    List<Employees> findAll();
    List<Employees> findByName(String name);
    List<Employees> findByNameLike(String character);
    List<Employees> findByAgeBetween(Integer start,Integer end);
}
