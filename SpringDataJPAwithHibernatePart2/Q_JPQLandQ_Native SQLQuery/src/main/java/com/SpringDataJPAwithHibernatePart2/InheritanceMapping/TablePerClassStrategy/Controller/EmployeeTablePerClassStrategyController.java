package com.SpringDataJPAwithHibernatePart2.InheritanceMapping.TablePerClassStrategy.Controller;

import com.SpringDataJPAwithHibernatePart2.InheritanceMapping.TablePerClassStrategy.Entity.ContractEmployeeTablePerClassStrategy;
import com.SpringDataJPAwithHibernatePart2.InheritanceMapping.TablePerClassStrategy.Entity.EmployeeTablePerClassStrategy;
import com.SpringDataJPAwithHibernatePart2.InheritanceMapping.TablePerClassStrategy.Entity.PermanentEmployeeTablePerClassStrategy;
import com.SpringDataJPAwithHibernatePart2.InheritanceMapping.TablePerClassStrategy.Service.EmployeeTablePerClassStrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class EmployeeTablePerClassStrategyController {
    @Autowired
    EmployeeTablePerClassStrategyService employeeTablePerClassStrategyService;

    @GetMapping("/employeeTablePerClassStrategy")
    public List<EmployeeTablePerClassStrategy> getEmployee(){
        return employeeTablePerClassStrategyService.getAllEmployee();
    }

    @GetMapping("/employeeTablePerClassStrategy/{id}")
    public EmployeeTablePerClassStrategy getEmployeeById(@PathVariable("id") Integer id){
        return employeeTablePerClassStrategyService.getEmployeeById(id);
    }

    @PostMapping("/employeeTablePerClassStrategy/create/permanent")
    public ResponseEntity<EmployeeTablePerClassStrategy> createEmployeePermanent(
            @RequestBody PermanentEmployeeTablePerClassStrategy permanentEmployeeTablePerClassStrategyData
    ){
        employeeTablePerClassStrategyService.createEmployeePermanent(permanentEmployeeTablePerClassStrategyData);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .replacePath("/employeeTablePerClassStrategy/"+ permanentEmployeeTablePerClassStrategyData.getId())
                .build()
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PostMapping("/employeeTablePerClassStrategy/create/contract")
    public ResponseEntity<EmployeeTablePerClassStrategy> createEmployeeContract(
            @RequestBody ContractEmployeeTablePerClassStrategy contractEmployeeData
    ){
        employeeTablePerClassStrategyService.createEmployeeContract(contractEmployeeData);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .replacePath("/employeeTablePerClassStrategy/"+contractEmployeeData.getId())
                .build()
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PostMapping("employeeTablePerClassStrategy/dummy")
    public ResponseEntity<EmployeeTablePerClassStrategy> createDummyEmployee(@Param("no") Integer no){
        employeeTablePerClassStrategyService.createDummyEmployee(no);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .replacePath("employeeTablePerClassStrategy")
                .build()
                .toUri();
        return ResponseEntity.created(location).build();
    }


}
