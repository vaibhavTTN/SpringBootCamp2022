package com.SpringDataJPAwithHibernatePart2.InheritanceMapping.JoinedStrategy.Controller;

import com.SpringDataJPAwithHibernatePart2.InheritanceMapping.JoinedStrategy.Entity.ContractEmployeeJoinedStrategy;
import com.SpringDataJPAwithHibernatePart2.InheritanceMapping.JoinedStrategy.Entity.EmployeeJoinedStrategy;
import com.SpringDataJPAwithHibernatePart2.InheritanceMapping.JoinedStrategy.Entity.PermanentEmployeeJoinedStrategy;
import com.SpringDataJPAwithHibernatePart2.InheritanceMapping.JoinedStrategy.Service.EmployeeJoinedStrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class EmployeeJoinedStrategyController {
    @Autowired
    EmployeeJoinedStrategyService employeeJoinedStrategyService;

    @GetMapping("/employeeJoinedStrategyService")
    public List<EmployeeJoinedStrategy> getEmployee(){
        return employeeJoinedStrategyService.getAllEmployee();
    }

    @GetMapping("/employeeJoinedStrategyService/{id}")
    public EmployeeJoinedStrategy getEmployeeById(@PathVariable("id") Integer id){
        return employeeJoinedStrategyService.getEmployeeById(id);
    }

    @PostMapping("/employeeJoinedStrategyService/create/permanent")
    public ResponseEntity<EmployeeJoinedStrategy> createEmployeePermanent(
            @RequestBody PermanentEmployeeJoinedStrategy permanentEmployeeTablePerClassStrategyData
    ){
        employeeJoinedStrategyService.createEmployeePermanent(permanentEmployeeTablePerClassStrategyData);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .replacePath("/employeeJoinedStrategyService/"+ permanentEmployeeTablePerClassStrategyData.getId())
                .build()
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PostMapping("/employeeJoinedStrategyService/create/contract")
    public ResponseEntity<EmployeeJoinedStrategy> createEmployeeContract(
            @RequestBody ContractEmployeeJoinedStrategy contractEmployeeData
    ){
        employeeJoinedStrategyService.createEmployeeContract(contractEmployeeData);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .replacePath("/employeeJoinedStrategyService/"+contractEmployeeData.getId())
                .build()
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PostMapping("employeeJoinedStrategyService/dummy")
    public ResponseEntity<EmployeeJoinedStrategy> createDummyEmployee(@Param("no") Integer no){
        employeeJoinedStrategyService.createDummyEmployee(no);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .replacePath("employeeJoinedStrategyService")
                .build()
                .toUri();
        return ResponseEntity.created(location).build();
    }


}
