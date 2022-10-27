package com.SpringDataJPAwithHibernatePart1.SpringDataJPAwithHibernatePart1.Seed;


import com.SpringDataJPAwithHibernatePart1.SpringDataJPAwithHibernatePart1.Entity.Employees;
import com.SpringDataJPAwithHibernatePart1.SpringDataJPAwithHibernatePart1.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class EmployeesSeed {

    @Autowired
    EmployeeRepository employeeRepository;
    private Integer getRandomIndex(int start, int end){
        Random r = new Random();
        return r.nextInt(end - start) + start;
    }

    private String getFirstName(){
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

    private String getLastname(){
        String[] lastName = {
                "Smith",
                "Johnson",
                "Williams",
                "Brown",
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

    private String getLocation(){
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

    public void getEmployees(int no){
        List<Employees> employees = new ArrayList<>();
        for (int i = 1; i<= no; i++){
            Employees emp = new Employees();
            emp.setAge(getRandomIndex(5,70));
            emp.setName(getFirstName()+" "+getLastname());
            emp.setLocation(getLocation());
            employees.add(emp);
        }
        employeeRepository.saveAll(employees);
    }
}
