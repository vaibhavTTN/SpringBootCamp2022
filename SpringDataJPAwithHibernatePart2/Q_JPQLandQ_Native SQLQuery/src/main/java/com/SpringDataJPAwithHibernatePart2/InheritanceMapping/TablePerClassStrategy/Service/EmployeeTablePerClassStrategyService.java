package com.SpringDataJPAwithHibernatePart2.InheritanceMapping.TablePerClassStrategy.Service;

import com.SpringDataJPAwithHibernatePart2.InheritanceMapping.Seed.EmployeeSeed;
import com.SpringDataJPAwithHibernatePart2.InheritanceMapping.TablePerClassStrategy.Entity.ContractEmployeeTablePerClassStrategy;
import com.SpringDataJPAwithHibernatePart2.InheritanceMapping.TablePerClassStrategy.Entity.EmployeeTablePerClassStrategy;
import com.SpringDataJPAwithHibernatePart2.InheritanceMapping.TablePerClassStrategy.Entity.PermanentEmployeeTablePerClassStrategy;
import com.SpringDataJPAwithHibernatePart2.InheritanceMapping.TablePerClassStrategy.Repository.EmployeeTablePerClassStrategyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeTablePerClassStrategyService {

    @Autowired
    private EmployeeTablePerClassStrategyRepository employeeTablePerClassStrategyRepository;

    @Autowired
    private EmployeeSeed employeeSeed;

    public List<EmployeeTablePerClassStrategy> getAllEmployee(){
        return employeeTablePerClassStrategyRepository.findAll();
    }

    public void createDummyEmployee(Integer no){
        employeeSeed.getEmployeeTablePerClassStrategy(no);
    }

    public EmployeeTablePerClassStrategy getEmployeeById(Integer id) {
        return employeeTablePerClassStrategyRepository.findById(id).get();
    }

    public void createEmployeePermanent(PermanentEmployeeTablePerClassStrategy permanentEmployeeTablePerClassStrategyData) {
        employeeTablePerClassStrategyRepository.save(permanentEmployeeTablePerClassStrategyData);
    }

    public void createEmployeeContract(ContractEmployeeTablePerClassStrategy contractEmployeeData) {
        employeeTablePerClassStrategyRepository.save(contractEmployeeData);
    }
}
