package com.SpringDataJPAwithHibernatePart2.InheritanceMapping.JoinedStrategy.Service;

import com.SpringDataJPAwithHibernatePart2.InheritanceMapping.JoinedStrategy.Entity.ContractEmployeeJoinedStrategy;
import com.SpringDataJPAwithHibernatePart2.InheritanceMapping.JoinedStrategy.Entity.EmployeeJoinedStrategy;
import com.SpringDataJPAwithHibernatePart2.InheritanceMapping.JoinedStrategy.Entity.PermanentEmployeeJoinedStrategy;
import com.SpringDataJPAwithHibernatePart2.InheritanceMapping.JoinedStrategy.Repository.EmployeeJoinedStrategyRepository;
import com.SpringDataJPAwithHibernatePart2.InheritanceMapping.Seed.EmployeeSeed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeJoinedStrategyService {

    @Autowired
    private EmployeeJoinedStrategyRepository employeeJoinedStrategyRepository;

    @Autowired
    private EmployeeSeed employeeSeed;


    public List<EmployeeJoinedStrategy> getAllEmployee(){
        return employeeJoinedStrategyRepository.findAll();
    }

    public void createDummyEmployee(Integer no){
        employeeSeed.getEmployeesJoinedStrategy(no);
    }

    public EmployeeJoinedStrategy getEmployeeById(Integer id) {
        return employeeJoinedStrategyRepository.findById(id).get();
    }

    public void createEmployeePermanent(PermanentEmployeeJoinedStrategy permanentEmployeeTablePerClassStrategyData) {
        employeeJoinedStrategyRepository.save(permanentEmployeeTablePerClassStrategyData);
    }

    public void createEmployeeContract(ContractEmployeeJoinedStrategy contractEmployeeData) {
        employeeJoinedStrategyRepository.save(contractEmployeeData);
    }
}
