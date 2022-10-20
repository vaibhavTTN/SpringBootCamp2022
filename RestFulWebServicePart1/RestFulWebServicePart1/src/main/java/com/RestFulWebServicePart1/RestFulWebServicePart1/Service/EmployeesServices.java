package com.RestFulWebServicePart1.RestFulWebServicePart1.Service;

import com.RestFulWebServicePart1.RestFulWebServicePart1.Models.Employee;
import com.RestFulWebServicePart1.RestFulWebServicePart1.ExceptionHandling.EmployeeNotFoundException;
import com.RestFulWebServicePart1.RestFulWebServicePart1.Seed.EmployeeSeed;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeesServices {
    static List<Employee> empList = new ArrayList<>();
    static Integer count;

    static {
        EmployeeSeed DummyList = new EmployeeSeed();
        empList.addAll(DummyList.getEmployeesList());
        count = empList.size();
    }


    public List<Employee> findAll(){
        return empList;
    }

    public Employee findById(Integer id){
        Employee empData = empList.stream()
                .filter(e -> e.getId()==id)
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException("Id Not Found :: "+id));

        return empData;
    }

    public Employee create(Employee emp){
        emp.setId(++count);
        empList.add(emp);
        return emp;
    }

    public Employee update(Integer id, Employee emp){
        Employee empData = empList.stream()
                                     .filter(e -> e.getId()==id)
                                     .findFirst()
                                     .orElseThrow(()->new EmployeeNotFoundException("Id Not Found :: "+id));

        empData.setName(emp.getName());
        empData.setAge(emp.getAge());
        return empData;
    }

    public Employee delete(Integer id){
        Employee empData = empList.stream()
                .filter(e -> e.getId()==id)
                .findFirst()
                .orElseThrow(()->new EmployeeNotFoundException("Id Not Found :: "+id));

        empList.removeIf(e -> e.getId() == id);
        return empData;
    }

}
