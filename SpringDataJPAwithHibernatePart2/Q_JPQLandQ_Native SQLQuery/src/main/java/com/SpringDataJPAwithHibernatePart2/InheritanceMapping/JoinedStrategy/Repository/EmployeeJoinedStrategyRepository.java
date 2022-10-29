package com.SpringDataJPAwithHibernatePart2.InheritanceMapping.JoinedStrategy.Repository;

import com.SpringDataJPAwithHibernatePart2.InheritanceMapping.JoinedStrategy.Entity.EmployeeJoinedStrategy;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeJoinedStrategyRepository extends CrudRepository<EmployeeJoinedStrategy,Integer> {
    List<EmployeeJoinedStrategy> findAll();
}
