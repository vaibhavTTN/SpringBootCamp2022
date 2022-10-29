package com.SpringDataJPAwithHibernatePart2.JPQLandNativeSQLQuery.Controller;

import com.SpringDataJPAwithHibernatePart2.JPQLandNativeSQLQuery.Entity.Employee;
import com.SpringDataJPAwithHibernatePart2.JPQLandNativeSQLQuery.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getEmployee(@Param("page") Integer page, @Param("size") Integer size) {
        return employeeService.getEmployee(page, size);
    }

    @PostMapping("/employees/dummy")
    public ResponseEntity<Employee> createDummyEmployees(@Param("no") Integer no) {
        employeeService.createDummyEmployee(no);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .replacePath("/employees")
                .build()
                .toUri();

        return ResponseEntity.created(location).build();
    }

    /*
            JPQL:
     */

    /*
       Display the first name, last name of all employees having
       salary greater than average salary ordered in ascending by
       their age and in descending by their salary.
    */
    @GetMapping("/getEmployeeSalaryGreaterThanAverageSalary")
    public List<Object> getEmployeeSalaryGreaterThanAverageSalary() {
        return employeeService.getEmployeeSalaryGreaterThanAverageSalary();
    }

    /*
            Update salary of all employees by a salary passed as
            a parameter whose existing salary is less than the average salary.
     */
    @PostMapping("/updateSalaryAllEmployeeLessThanAverageSalary")
    public ResponseEntity<Employee> updateSalaryAllEmployeeLessThanAverageSalary(@Param("setSalary") Double setSalary){
        employeeService.updateSalaryAllEmployeeLessThanAverageSalary(setSalary);
        return ResponseEntity.accepted().build();
    }

    /*
            Delete all employees with minimum salary.
     */
    @DeleteMapping("/deleteEmployeeWithMinSalary")
    public ResponseEntity<Employee> deleteEmployeeWithMinSalary() {
        employeeService.deleteEmployeeWithMinSalary();
        return ResponseEntity.accepted().build();
    }

    /*
            Native SQL Query:
     */
    /*
          Q1.  Display the id, first name, age of all employees
                where last name ends with "singh"
     */
    @GetMapping("/getEmployeeByLastNameSingh")
    public List<Object> getEmployeeByLastNameSingh() {
        return employeeService.getEmployeeByLastNameSingh();
    }

    /*
            Delete all employees with age greater than 45(Should be passed as a parameter)
     */
    @DeleteMapping("/deleteAllEmployeeAgeGreaterThan")
    public ResponseEntity<Employee> deleteAllEmployeeAgeGreaterThan(@Param("Age") Integer Age) {
        employeeService.deleteAllEmployeeAgeGreaterThan(Age);
        return ResponseEntity.accepted().build();
    }

}
