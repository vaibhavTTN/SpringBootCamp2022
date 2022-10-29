package com.SpringDataJPAwithHibernatePart2.InheritanceMapping.Seed;

import com.SpringDataJPAwithHibernatePart2.ComponentMapping.Entity.EmployeeComponentMapping;
import com.SpringDataJPAwithHibernatePart2.ComponentMapping.Entity.Salary;
import com.SpringDataJPAwithHibernatePart2.ComponentMapping.Repository.EmployeeComponentMappingRepository;
import com.SpringDataJPAwithHibernatePart2.InheritanceMapping.JoinedStrategy.Entity.ContractEmployeeJoinedStrategy;
import com.SpringDataJPAwithHibernatePart2.InheritanceMapping.JoinedStrategy.Entity.EmployeeJoinedStrategy;
import com.SpringDataJPAwithHibernatePart2.InheritanceMapping.JoinedStrategy.Entity.PermanentEmployeeJoinedStrategy;
import com.SpringDataJPAwithHibernatePart2.InheritanceMapping.JoinedStrategy.Repository.EmployeeJoinedStrategyRepository;
import com.SpringDataJPAwithHibernatePart2.InheritanceMapping.SingleTableStrategy.Entity.ContractEmployee;
import com.SpringDataJPAwithHibernatePart2.InheritanceMapping.SingleTableStrategy.Entity.EmployeeSingleTableStrategy;
import com.SpringDataJPAwithHibernatePart2.InheritanceMapping.SingleTableStrategy.Entity.PermanentEmployee;
import com.SpringDataJPAwithHibernatePart2.InheritanceMapping.SingleTableStrategy.Repository.EmployeeSingleTableStrategyRepository;
import com.SpringDataJPAwithHibernatePart2.InheritanceMapping.TablePerClassStrategy.Entity.ContractEmployeeTablePerClassStrategy;
import com.SpringDataJPAwithHibernatePart2.InheritanceMapping.TablePerClassStrategy.Entity.EmployeeTablePerClassStrategy;
import com.SpringDataJPAwithHibernatePart2.InheritanceMapping.TablePerClassStrategy.Entity.PermanentEmployeeTablePerClassStrategy;
import com.SpringDataJPAwithHibernatePart2.InheritanceMapping.TablePerClassStrategy.Repository.EmployeeTablePerClassStrategyRepository;
import com.SpringDataJPAwithHibernatePart2.InheritanceMapping.TablePerClassStrategy.Service.EmployeeTablePerClassStrategyService;
import com.SpringDataJPAwithHibernatePart2.JPQLandNativeSQLQuery.Seed.EmployeesSeed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeSeed {

    @Autowired
    EmployeesSeed employeesSeed;
    @Autowired
    EmployeeSingleTableStrategyRepository employeeSingleTableStrategyRepository;

    @Autowired
    EmployeeTablePerClassStrategyRepository employeeTablePerClassStrategyRepository;

    @Autowired
    EmployeeJoinedStrategyRepository employeeJoinedStrategyRepository;

    @Autowired
    EmployeeComponentMappingRepository employeeComponentMappingRepository;


    public void getEmployees(Integer no){
        List<EmployeeSingleTableStrategy> employees = new ArrayList<>();
        boolean flag = true;
        for (int i = 1; i<= no; i++){
            if (flag){
                PermanentEmployee perEmp = new PermanentEmployee();
                perEmp.setName(employeesSeed.getFirstName()+employeesSeed.getLastname());
                perEmp.setDesignation(employeesSeed.getDesignation());
                flag = false;
                employees.add(perEmp);
            }else {
                ContractEmployee conEmp = new ContractEmployee();
                conEmp.setName(employeesSeed.getFirstName()+employeesSeed.getLastname());
                conEmp.setDesignation(employeesSeed.getDesignation());
                flag = true;
                employees.add(conEmp);
            }
        }
        employeeSingleTableStrategyRepository.saveAll(employees);
    }

    public void getEmployeeTablePerClassStrategy(Integer no){
        List<EmployeeTablePerClassStrategy> employees = new ArrayList<>();
        boolean flag = true;
        for (int i = 1; i<= no; i++){
            if (flag){
                PermanentEmployeeTablePerClassStrategy perEmp = new PermanentEmployeeTablePerClassStrategy();
                perEmp.setName(employeesSeed.getFirstName()+employeesSeed.getLastname());
                perEmp.setDesignation(employeesSeed.getDesignation());
                flag = false;
                employees.add(perEmp);
            }else {
                ContractEmployeeTablePerClassStrategy conEmp = new ContractEmployeeTablePerClassStrategy();
                conEmp.setName(employeesSeed.getFirstName()+employeesSeed.getLastname());
                conEmp.setDesignation(employeesSeed.getDesignation());
                flag = true;
                employees.add(conEmp);
            }
        }
        employeeTablePerClassStrategyRepository.saveAll(employees);
    }

    public void getEmployeesJoinedStrategy(Integer no){
        List<EmployeeJoinedStrategy> employees = new ArrayList<>();
        boolean flag = true;
        for (int i = 1; i<= no; i++){
            if (flag){
                PermanentEmployeeJoinedStrategy perEmp = new PermanentEmployeeJoinedStrategy();
                perEmp.setName(employeesSeed.getFirstName()+employeesSeed.getLastname());
                perEmp.setDesignation(employeesSeed.getDesignation());
                flag = false;
                employees.add(perEmp);
            }else {
                ContractEmployeeJoinedStrategy conEmp = new ContractEmployeeJoinedStrategy();
                conEmp.setName(employeesSeed.getFirstName()+employeesSeed.getLastname());
                conEmp.setDesignation(employeesSeed.getDesignation());
                flag = true;
                employees.add(conEmp);
            }
        }
        employeeJoinedStrategyRepository.saveAll(employees);
    }


    public void getEmployeeComponentMapping(Integer no) {
        List<EmployeeComponentMapping> employees = new ArrayList<>();
        for (int i = 1; i<= no; i++){
                EmployeeComponentMapping employeeComponentMapping = new EmployeeComponentMapping();
                employeeComponentMapping.setFirstName(employeesSeed.getFirstName());
                employeeComponentMapping.setLastName(employeesSeed.getLastname());
                employeeComponentMapping.setAge(employeesSeed.getRandomIndex(10,90));

                Salary salary = new Salary();
                salary.setBasicSalary(employeesSeed.getRandomSalary(10000D,50000D));
                salary.setBonusSalary(employeesSeed.getRandomSalary(1000D,5000D));
                salary.setTaxAmount(employeesSeed.getRandomSalary(1000D,5000D));
                salary.setSpecialAllowanceSalary(employeesSeed.getRandomSalary(10000D,15000D));
                employeeComponentMapping.setSalary(salary);
                employees.add(employeeComponentMapping);
        }
        employeeComponentMappingRepository.saveAll(employees);
    }
}
