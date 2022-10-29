package com.SpringDataJPAwithHibernatePart2.ComponentMapping.Repository;

import com.SpringDataJPAwithHibernatePart2.ComponentMapping.Entity.EmployeeComponentMapping;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeComponentMappingRepository extends CrudRepository<EmployeeComponentMapping,Integer> {
    List<EmployeeComponentMapping> findAll();
}
