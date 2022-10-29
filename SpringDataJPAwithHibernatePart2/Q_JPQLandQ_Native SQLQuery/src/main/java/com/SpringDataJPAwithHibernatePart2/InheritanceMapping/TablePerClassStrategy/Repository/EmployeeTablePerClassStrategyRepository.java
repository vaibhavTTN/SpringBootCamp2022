package com.SpringDataJPAwithHibernatePart2.InheritanceMapping.TablePerClassStrategy.Repository;

import com.SpringDataJPAwithHibernatePart2.InheritanceMapping.TablePerClassStrategy.Entity.EmployeeTablePerClassStrategy;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeTablePerClassStrategyRepository extends CrudRepository<EmployeeTablePerClassStrategy,Integer> {
    List<EmployeeTablePerClassStrategy> findAll();
}
