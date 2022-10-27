package com.SpringDataJPAwithHibernatePart1.SpringDataJPAwithHibernatePart1.Service;

import com.SpringDataJPAwithHibernatePart1.SpringDataJPAwithHibernatePart1.Entity.Employees;
import com.SpringDataJPAwithHibernatePart1.SpringDataJPAwithHibernatePart1.ExceptionHandling.EmployeeNotFoundException;
import com.SpringDataJPAwithHibernatePart1.SpringDataJPAwithHibernatePart1.Repository.EmployeeRepository;
import com.SpringDataJPAwithHibernatePart1.SpringDataJPAwithHibernatePart1.Seed.EmployeesSeed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeesSeed employeesSeed;

    /*
           (3) Perform Create Operation on Entity using Spring Data JPA
           Used For Creating the Employee data in Employee table
     */
    public Employees create(Employees emp){
        Employees empData = new Employees();
        empData.setName(emp.getName());
        empData.setLocation(emp.getLocation());
        empData.setAge(emp.getAge());
        employeeRepository.save(empData);
        return empData;
    }


    /*
            (4) Perform Update Operation on Entity using Spring Data JPA
            -> used for updating the Employee data in employees table
     */
    public Employees updateById(Integer id,Employees emp){
        Employees empData = employeeRepository.findById(id).get();
        empData.setName(emp.getName());
        empData.setLocation(emp.getLocation());
        empData.setAge(emp.getAge());
        employeeRepository.save(empData);
        return empData;
    }

    /*
            (5) Perform Delete Operation on Entity using Spring Data JPA
            -> used for deleting the employee data from employee table
     */
    public void DeleteById(Integer id){
        if(!employeeRepository.existsById(id)){
            throw new EmployeeNotFoundException("Id not found :: "+id);
        }
        Employees empData = employeeRepository.findById(id).get();
        employeeRepository.delete(empData);
    }

    /*
            5) Perform Read Operation on Entity using Spring Data JPA
            -> used for reading the data by id of employee
     */
    public Employees findById(Integer id){
        if(!employeeRepository.existsById(id)){
            throw new EmployeeNotFoundException("Id not found :: "+id);
        }
        return employeeRepository.findById(id).get();
    }

    /*
        (6) Get the total count of the number of Employees
        -> getting the total count of employee present in employee table
     */
    public Map<String,Long> count(){
        Map<String,Long> empCount = new HashMap<>();
        empCount.put("Count",employeeRepository.count());
        return empCount;
    }

    /*
            (7) Implement Pagination and Sorting on the bases of Employee Age
     */
    public List<Employees> employeeSortByAge(Integer pageNo,Integer size){
        if(size==null) {
            size = 5;
        }
        if(pageNo==null){
            pageNo = 0;
        }
        Pageable sortedByAge = PageRequest.of(pageNo, size, Sort.by("age"));
        List<Employees> empData = new ArrayList<>();
        employeeRepository.findAll(sortedByAge).forEach(empData::add);
        return empData;
    }


    /*
        (8) Create and use finder to find Employee by Name
     */
    public List<Employees> findByName(String name){
        return employeeRepository.findByName(name);
    }

    /*
            (9) Create and use finder to find Employees starting with A character
     */
    public List<Employees> findByNameLike(String character){
        return employeeRepository.findByNameLike(character+"%");
    }

    /*
            (10) Create and use finder to find Employees Between the age of 28 to 32
     */
    public List<Employees> findByAgeBetween(Integer start,Integer end){
        return employeeRepository.findByAgeBetween(start,end);
    }

    /*
            This used for creating the list of dummy data of employee in employee table
     */
    public void createDummyEmployees(Integer number){
        if(number == null){
            number = 10;
        }
        employeesSeed.getEmployees(number);
    }

    /*
        this is used for list all the data of employee
     */
    public List<Employees> findAll(){
        return employeeRepository.findAll();
    }

    /*
        This is used for delete all the employee data from employee table;
     */
    public void deleteAll(){
        employeeRepository.deleteAll();
    }
}
