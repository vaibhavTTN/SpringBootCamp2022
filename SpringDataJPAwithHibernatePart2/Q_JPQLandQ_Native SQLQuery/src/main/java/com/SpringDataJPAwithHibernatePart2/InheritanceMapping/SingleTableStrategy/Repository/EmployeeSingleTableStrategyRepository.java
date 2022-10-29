package com.SpringDataJPAwithHibernatePart2.InheritanceMapping.SingleTableStrategy.Repository;

import com.SpringDataJPAwithHibernatePart2.InheritanceMapping.SingleTableStrategy.Entity.EmployeeSingleTableStrategy;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeSingleTableStrategyRepository extends CrudRepository<EmployeeSingleTableStrategy,Integer> {
    List<EmployeeSingleTableStrategy> findAll();
}
