package com.RestFulWebServicePart1.RestFulWebServicePart1.Controllers;

import com.RestFulWebServicePart1.RestFulWebServicePart1.Models.Employee;
import com.RestFulWebServicePart1.RestFulWebServicePart1.Service.EmployeesServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class EmployeesResources {

    @Autowired
    private final EmployeesServices EmployeesServices;

    public EmployeesResources(EmployeesServices EmployeesServices){
        this.EmployeesServices = EmployeesServices;
    }

    @GetMapping("/employees")
    public List<Employee> EmployeesAllList(){
        return EmployeesServices.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee FindEmployees(@PathVariable Integer id){
        return EmployeesServices.findById(id);
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> AddEmployee(@Valid @RequestBody Employee emp){
        Employee saveEmp = EmployeesServices.create(emp);
        URI location = ServletUriComponentsBuilder
                            .fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(saveEmp.getId())
                            .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> UpdateDetails(@PathVariable Integer id,@Valid @RequestBody Employee emp){
        Employee saveEmp = EmployeesServices.update(id,emp);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path(null)
                .build()
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Employee> DeleteEmployee(@PathVariable Integer id){
        Employee saveEmp = EmployeesServices.delete(id);
        return ResponseEntity.accepted().build();
    }

}
