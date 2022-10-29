package com.SpringDataJPAwithHibernatePart2.JPQLandNativeSQLQuery.Seed;


import com.SpringDataJPAwithHibernatePart2.JPQLandNativeSQLQuery.Entity.Employee;
import com.SpringDataJPAwithHibernatePart2.JPQLandNativeSQLQuery.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class EmployeesSeed {

    @Autowired
    EmployeeRepository employeeRepository;
    public Integer getRandomIndex(int start, int end){
        Random r = new Random();
        return r.nextInt(end - start) + start;
    }

    public Double getRandomSalary(Double start, Double end){
        Random r = new Random();
        return r.nextDouble(end - start) + start;
    }
    public String getFirstName(){
        String[] firstname = {"Michael",
                "Christopher",
                "Jessica",
                "Matthew",
                "Ashley",
                "Jennifer",
                "Joshua",
                "Amanda",
                "Daniel",
                "David",
                "James",
                "Robert",
                "John",
                "Joseph",
                "Andrew",
                "Ryan",
                "Brandon",
                "Jason",
                "Justin",
                "Sarah",
                "William",
                "Jonathan",
                "Stephanie",
                "Brian",
                "Nicole",
                "Nicholas",
                "Anthony",
                "Heather",
                "Eric",
                "Elizabeth",
                "Adam",
                "Megan",
                "Melissa",
                "Kevin",
                "Steven"
        };
        int index = getRandomIndex(0,firstname.length-1);
        return firstname[index];
    }

    public String getLastname(){
        String[] lastName = {
                "Smith",
                "Johnson",
                "Williams",
                "Brown",
                "Singh",
                "Jones",
                "Garcia",
                "Miller",
                "Davis",
                "Rodriguez",
                "Martinez",
                "Hernandez",
                "Lopez",
                "Gonzalez",
                "Wilson",
                "Anderson",
                "Thomas",
                "Taylor",
                "Moore",
                "Jackson",
                "Martin",
                "Lee",
                "Perez",
                "Thompson",
                "White",
                "Harris",
                "Sanchez",
                "Clark",
                "Ramirez",
                "Lewis",
                "Robinson",
                "Walker",
                "Young",
                "Allen",
                "King",
                "Wright",
                "Scott",
                "Torres",
                "Nguyen",
                "Hill",
                "Flores",
                "Green",
                "Adams",
                "Nelson",
                "Baker",
                "Hall",
                "Rivera",
                "Campbell",
                "Mitchell",
                "Carter",
                "Roberts"
        };
        int index = getRandomIndex(0,lastName.length-1);
        return lastName[index];
    }

    public String getLocation(){
        String[] location = {
                "Andaman and Nicobar Islands",
                "Andhra Pradesh",
                "Arunachal Pradesh",
                "Assam",
                "Bihar",
                "Chandigarh",
                "Chhattisgarh",
                "Dadra and Nagar Haveli",
                "Daman and Diu",
                "Delhi",
                "Goa",
                "Gujarat",
                "Haryana",
                "Himachal Pradesh",
                "Jammu and Kashmir",
                "Jharkhand",
                "Karnataka",
                "Kerala",
                "Ladakh",
                "Lakshadweep",
                "Madhya Pradesh",
               "Maharashtra",
               "Manipur",
               "Meghalaya",
               "Mizoram",
               "Nagaland",
               "Odisha",
               "Puducherry",
               "Punjab",
               "Rajasthan",
               "Sikkim",
               "Tamil Nadu",
               "Telangana",
               "Tripura",
               "Uttar Pradesh",
               "Uttarakhand",
               "West Bengal"
    };
        int index = getRandomIndex(0,location.length-1);
        return location[index];
    }

    public String getDesignation(){
        String[] designation = {
                "Product Manager",
                "VP of Marketing",
                "VP of Engineering",
                "Director of Engineering",
                "Chief Architect",
                "Software Architect",
                "Engineering Project Manager",
                "Engineering Manager",
                "Technical Lead",
                "Engineering Lead",
                "Team Lead",
                "Principal Software Engineer",
                "Senior Software Engineer",
                "Senior Software Developer",
                "Software Engineer",
                "Software Developer",
                "Junior Software Developer",
                "Intern Software Developer"
        };
        int index = getRandomIndex(0,designation.length-1);
        return designation[index];
    }

    public void getEmployees(int no){
        List<Employee> employees = new ArrayList<>();
        for (int i = 1; i<= no; i++){
            Employee emp = new Employee();
            emp.setEmpAge(getRandomIndex(21,70));
            emp.setEmpFirstName(getFirstName());
            emp.setEmpLastName(getLastname());
            emp.setEmpSalary(getRandomSalary(10000D,50000D));
            employees.add(emp);
        }
        employeeRepository.saveAll(employees);
    }
}
