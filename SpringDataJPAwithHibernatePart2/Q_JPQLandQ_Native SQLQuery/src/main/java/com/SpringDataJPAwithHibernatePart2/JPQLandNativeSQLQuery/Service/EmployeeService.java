package com.SpringDataJPAwithHibernatePart2.JPQLandNativeSQLQuery.Service;

import com.SpringDataJPAwithHibernatePart2.JPQLandNativeSQLQuery.Entity.Employee;
import com.SpringDataJPAwithHibernatePart2.JPQLandNativeSQLQuery.Repository.EmployeeRepository;
import com.SpringDataJPAwithHibernatePart2.JPQLandNativeSQLQuery.Seed.EmployeesSeed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeesSeed employeesSeed;

    /*
        List out all the Data of Employee table in pagination form
     */
    public List<Employee> getEmployee(Integer pageNo,Integer size){
        Pageable pageable = PageRequest.of((pageNo==null)?0:pageNo,
                (size==null)?(int)employeeRepository.count():size);
        return employeeRepository.findAll(pageable);
    }

    /*
        Display the first name, last name of all employees having
        salary greater than average salary ordered in ascending by
        their age and in descending by their salary.
     */
    public List<Object> getEmployeeSalaryGreaterThanAverageSalary(){
        return employeeRepository.getEmployeeSalaryGreaterThanAverageSalary();
    }

    /*
            Update salary of all employees by a salary passed as
            a parameter whose existing salary is less than the average salary.
     */
    public void updateSalaryAllEmployeeLessThanAverageSalary(Double setSalary){
        Double avgSalary = employeeRepository.getAvgSalary();
        employeeRepository.updateSalaryAllEmployeeLessThanAverageSalary(setSalary,avgSalary);
    }

    /*
            Delete all employees with minimum salary.
     */
    @Transactional
    public void deleteEmployeeWithMinSalary(){
        Double minSalary = employeeRepository.getMinSalary();
        employeeRepository.deleteMinimumSalary(minSalary);
    }


    /*
         Q1.  Display the id, first name, age of all employees where last name ends with "singh"
    */
    public List<Object> getEmployeeByLastNameSingh(){
        return employeeRepository.getEmployeeByLastNameSinghNative();
    }

    /*
        Delete all employees with age greater than 45(Should be passed as a parameter)
     */
    public void deleteAllEmployeeAgeGreaterThan(Integer Age){
        employeeRepository.deleteAllEmployeeAgeGreaterThan(Age);
    }


    /*
        To create the dummy data in employee tables
     */
    public void createDummyEmployee(Integer no){
        employeesSeed.getEmployees((no==null)?10:no);
    }
}
