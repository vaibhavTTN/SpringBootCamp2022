package com.SpringDataJPAwithHibernatePart2.InheritanceMapping.SingleTableStrategy.Controller;

import com.SpringDataJPAwithHibernatePart2.InheritanceMapping.SingleTableStrategy.Entity.ContractEmployee;
import com.SpringDataJPAwithHibernatePart2.InheritanceMapping.SingleTableStrategy.Entity.EmployeeSingleTableStrategy;
import com.SpringDataJPAwithHibernatePart2.InheritanceMapping.SingleTableStrategy.Entity.PermanentEmployee;
import com.SpringDataJPAwithHibernatePart2.InheritanceMapping.SingleTableStrategy.Service.EmployeeSingleTableStrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class EmployeeSingleTableStrategyController {
    @Autowired
    EmployeeSingleTableStrategyService employeeSingleTableStrategyService;



    @GetMapping("/employeeSingleTableStrategy")
    public List<EmployeeSingleTableStrategy> getEmployee(){
        return employeeSingleTableStrategyService.getAllEmployee();
    }

    @GetMapping("/employeeSingleTableStrategy/{id}")
    public EmployeeSingleTableStrategy getEmployeeById(@PathVariable("id") Integer id){
        return employeeSingleTableStrategyService.getEmployeeById(id);
    }

    @PostMapping("/employeeSingleTableStrategy/create/permanent")
    public ResponseEntity<EmployeeSingleTableStrategy> createEmployeePermanent(
            @RequestBody PermanentEmployee permanentEmployeeData
    ){
        employeeSingleTableStrategyService.createEmployeePermanent(permanentEmployeeData);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .replacePath("/employeeSingleTableStrategy/"+permanentEmployeeData.getId())
                .build()
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PostMapping("/employeeSingleTableStrategy/create/contract")
    public ResponseEntity<EmployeeSingleTableStrategy> createEmployeeContract(
            @RequestBody ContractEmployee contractEmployeeData
    ){
        employeeSingleTableStrategyService.createEmployeeContract(contractEmployeeData);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .replacePath("/employeeSingleTableStrategy/"+contractEmployeeData.getId())
                .build()
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PostMapping("employeeSingleTableStrategy/dummy")
    public ResponseEntity<EmployeeSingleTableStrategy> createDummyEmployee(@Param("no") Integer no){
        employeeSingleTableStrategyService.createDummyEmployee(no);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .replacePath("employeeSingleTableStrategy")
                .build()
                .toUri();
        return ResponseEntity.created(location).build();
    }


}
