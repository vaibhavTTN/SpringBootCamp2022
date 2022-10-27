package com.SpringDataJPAwithHibernatePart1.SpringDataJPAwithHibernatePart1.Controller;

import com.SpringDataJPAwithHibernatePart1.SpringDataJPAwithHibernatePart1.Entity.Employees;
import com.SpringDataJPAwithHibernatePart1.SpringDataJPAwithHibernatePart1.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Map;


@RestController
public class EmployeesController {

    @Autowired
    private EmployeeService employeeService;

/*
    (3) Perform Create Operation on Entity using Spring Data JPA
 */
    @PostMapping("/employees")
    public ResponseEntity<Employees> create(@Valid @RequestBody Employees emp){
        Employees empData = employeeService.create(emp);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(empData.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    /*
        (5) Perform Read Operation on Entity using Spring Data JPA
     */
    @GetMapping("/employees/{id}")
    public Employees findById(@PathVariable Integer id){
        return employeeService.findById(id);
    }

    /*
            (4) Perform Update Operation on Entity using Spring Data JPA
            -> used for updating the Employee data in employees table
     */
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employees> updateById(@PathVariable Integer id,@Valid @RequestBody Employees emp){
        Employees empData = employeeService.updateById(id,emp);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path(null)
                .build()
                .toUri();
        return ResponseEntity.created(location).build();
    }

    /*
            (5) Perform Delete Operation on Entity using Spring Data JPA
            -> used for deleting the employee data from employee table
     */
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Employees> DeleteById(@PathVariable Integer id){
        employeeService.DeleteById(id);
        return ResponseEntity.accepted().build();
    }

    /*
        (6) Get the total count of the number of Employees
        -> getting the total count of employee present in employee table
     */
    @GetMapping("employees/count")
    public Map<String,Long> countEmployees(){
        return employeeService.count();
    }

    /*
            (7) Implement Pagination and Sorting on the bases of Employee Age

            http://localhost:8080/employees/sort/age?page=0&size=5

            By default page = 0 and size = 10
     */
    @GetMapping("employees/sort/age")
    public List<Employees> employeesListSortByAge(@Param("page") Integer page,@Param("size") Integer size){
        return employeeService.employeeSortByAge(page,size);
    }

    /*
            (8) Create and use finder to find Employee by Name
     */
    @GetMapping("employees/name/{name}")
    public List<Employees> findByName(@PathVariable String name){
        return employeeService.findByName(name);
    }

    /*
            (9) Create and use finder to find Employees starting with A character
     */
    @GetMapping("/employees/character/{character}")
    public List<Employees> findNameByFirstCharacter(@PathVariable String character){
        return employeeService.findByNameLike(character);
    }

    /*
            (10) Create and use finder to find Employees Between the age of 28 to 32
     */
    @GetMapping("/employees/age/{start}/{end}")
    public List<Employees> findAgeBetween(@PathVariable Integer start ,@PathVariable Integer end){
        return employeeService.findByAgeBetween(start,end);
    }

    /*
                This used for creating the list of dummy data of employee in employee table

                http://localhost:8080/employee/dummy?number=20
                by Default number = 10
     */
    @PostMapping("/employees/dummy")
    public void dummyEmployees(@Valid @Param("number") Integer number){
        employeeService.createDummyEmployees(number);
    }

    /*
        this is used for list all the data of employee
     */
    @GetMapping("/employees")
    public List<Employees> findAll(){
        return employeeService.findAll();
    }

    /*
        This is used for delete all the employee data from employee table;
     */
    @DeleteMapping("/employees/delete/all")
    public ResponseEntity<Employees> deleteAll(){
        employeeService.deleteAll();
        return ResponseEntity.accepted().build();
    }
}
