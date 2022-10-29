package com.SpringDataJPAwithHibernatePart2.ComponentMapping.Controller;

import com.SpringDataJPAwithHibernatePart2.ComponentMapping.Entity.EmployeeComponentMapping;
import com.SpringDataJPAwithHibernatePart2.ComponentMapping.Service.EmployeeComponentMappingService;
import com.SpringDataJPAwithHibernatePart2.InheritanceMapping.JoinedStrategy.Entity.EmployeeJoinedStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class EmployeeComponentMappingController {
    @Autowired
    EmployeeComponentMappingService employeeComponentMappingService;

    @GetMapping("/employeeComponentMapping")
    public List<EmployeeComponentMapping> getEmployee(){
        return employeeComponentMappingService.getAllEmployee();
    }

    @GetMapping("/employeeComponentMapping/{id}")
    public EmployeeComponentMapping getEmployeeById(@PathVariable("id") Integer id){
        return employeeComponentMappingService.getEmployeeById(id);
    }

    @PostMapping("/employeeComponentMapping/create")
    public ResponseEntity<EmployeeJoinedStrategy> createEmployeeComponentMapping(
            @RequestBody EmployeeComponentMapping employeeComponentMapping
    ){
        employeeComponentMappingService.createEmployeeComponentMapping(employeeComponentMapping);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .replacePath("/employeeComponentMapping/"+ employeeComponentMapping.getId())
                .build()
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PostMapping("employeeComponentMapping/dummy")
    public ResponseEntity<EmployeeComponentMapping> createDummyEmployee(@Param("no") Integer no){
        employeeComponentMappingService.createDummyEmployee(no);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .replacePath("employeeComponentMapping")
                .build()
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
