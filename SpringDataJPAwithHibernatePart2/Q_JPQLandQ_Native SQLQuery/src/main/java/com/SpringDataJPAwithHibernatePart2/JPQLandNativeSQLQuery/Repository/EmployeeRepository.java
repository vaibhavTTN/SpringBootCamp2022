package com.SpringDataJPAwithHibernatePart2.JPQLandNativeSQLQuery.Repository;

import com.SpringDataJPAwithHibernatePart2.JPQLandNativeSQLQuery.Entity.Employee;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


public interface EmployeeRepository extends CrudRepository<Employee,Integer> {
    List<Employee> findAll(Pageable pageable);

    /*
            JPQL: Query
     */
    /*
        Display the first name, last name of all employees having salary greater
        than average salary ordered in ascending by their age and in descending
        by their salary.
     */
    @Query("select empFirstName,empLastName from Employee where empSalary>(select avg(empSalary) from Employee) order by empAge Asc,empSalary Desc")
    List<Object> getEmployeeSalaryGreaterThanAverageSalary();

    /*
        Update salary of all employees by a salary passed as a parameter
        whose existing salary is less than the average salary.
     */
    @Transactional
    @Modifying
    @Query("update Employee set empSalary = :setSalary where empSalary<:avgSalary")
    void updateSalaryAllEmployeeLessThanAverageSalary(@Param("setSalary") Double setSalary, @Param("avgSalary") Double avgSalary);

    @Query("select avg(empSalary) as salary from Employee")
    Double getAvgSalary();
    /*
            Delete all employees with minimum salary.
     */
    @Transactional
    @Modifying
    @Query("Delete from Employee as emp1 where empSalary <=:minSalary")
    void deleteMinimumSalary(@Param("minSalary") Double minSalary);

    @Query("select min(empSalary) as salary from Employee")
    Double getMinSalary();


    /*
            Native SQL Query:
     */
    /*
          Q1.  Display the id, first name, age of all employees where last name ends with "singh"
     */
    @Query(
            value = "Select e.id,e.firstName,e.lastName from employeeTable as e where lastName like 'singh%'",
            nativeQuery = true
    )
    List<Object> getEmployeeByLastNameSinghNative();

    /*
        Delete all employees with age greater than 45(Should be passed as a parameter)
     */
    @Transactional
    @Modifying
    @Query(
            value = "Delete from employeeTable where age>:Age",
            nativeQuery = true
    )
    void deleteAllEmployeeAgeGreaterThan(@Param("Age") Integer Age);
}
