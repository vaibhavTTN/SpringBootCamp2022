package com.SpringDataJPAwithHibernatePart2.InheritanceMapping.SingleTableStrategy.Service;

import com.SpringDataJPAwithHibernatePart2.InheritanceMapping.Seed.EmployeeSeed;
import com.SpringDataJPAwithHibernatePart2.InheritanceMapping.SingleTableStrategy.Entity.ContractEmployee;
import com.SpringDataJPAwithHibernatePart2.InheritanceMapping.SingleTableStrategy.Entity.EmployeeSingleTableStrategy;
import com.SpringDataJPAwithHibernatePart2.InheritanceMapping.SingleTableStrategy.Entity.PermanentEmployee;
import com.SpringDataJPAwithHibernatePart2.InheritanceMapping.SingleTableStrategy.Repository.EmployeeSingleTableStrategyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeSingleTableStrategyService {

    @Autowired
    private EmployeeSingleTableStrategyRepository employeeSingleTableStrategyRepository;

    @Autowired
    private EmployeeSeed employeeSeed;


    public List<EmployeeSingleTableStrategy> getAllEmployee(){
        return employeeSingleTableStrategyRepository.findAll();
    }

    public void createDummyEmployee(Integer no){
        employeeSeed.getEmployees(no);
    }

    public EmployeeSingleTableStrategy getEmployeeById(Integer id) {
        return employeeSingleTableStrategyRepository.findById(id).get();
    }

    public void createEmployeePermanent(PermanentEmployee permanentEmployeeData) {
        employeeSingleTableStrategyRepository.save(permanentEmployeeData);
    }

    public void createEmployeeContract(ContractEmployee contractEmployeeData) {
        employeeSingleTableStrategyRepository.save(contractEmployeeData);
    }
}
