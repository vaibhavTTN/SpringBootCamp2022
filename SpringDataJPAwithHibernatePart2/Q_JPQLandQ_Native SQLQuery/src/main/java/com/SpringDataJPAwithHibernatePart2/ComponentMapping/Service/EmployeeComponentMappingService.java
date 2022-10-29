package com.SpringDataJPAwithHibernatePart2.ComponentMapping.Service;



import com.SpringDataJPAwithHibernatePart2.ComponentMapping.Entity.EmployeeComponentMapping;
import com.SpringDataJPAwithHibernatePart2.ComponentMapping.Repository.EmployeeComponentMappingRepository;
import com.SpringDataJPAwithHibernatePart2.InheritanceMapping.Seed.EmployeeSeed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeComponentMappingService {

    @Autowired
    EmployeeComponentMappingRepository employeeComponentMappingRepository;

    @Autowired
    EmployeeSeed employeeSeed;

    public List<EmployeeComponentMapping> getAllEmployee(){
        return employeeComponentMappingRepository.findAll();
    }

    public void createDummyEmployee(Integer no){
        employeeSeed.getEmployeeComponentMapping(no);
    }

    public EmployeeComponentMapping getEmployeeById(Integer id) {
        return employeeComponentMappingRepository.findById(id).get();
    }

    public void createEmployeeComponentMapping(EmployeeComponentMapping employeeComponentMapping) {
        employeeComponentMappingRepository.save(employeeComponentMapping);
    }
}
