package com.RestFulWebServicePart1.RestFulWebServicePart1.Seed;

import com.RestFulWebServicePart1.RestFulWebServicePart1.Models.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EmployeeSeed {

    List<Employee> Employees = new ArrayList<>();

    public List<Employee> getEmployeesList(){
        String[] name = {
                "SHRI NARESH KUMAR DHIRAN",
                "SHRI MOHD. MONIS KHAN",
                "SHRI PARESH KUMAR DURIA",
                "SHRI R. SRINIWAS",
                "SHRI R. MURLIDHARA NAIK",
                "SHRI ANIL KUMAR RATHORE",
                "DR SANDEEP KUMAR RAUT",
                "SHRI JACOB MANOHAR A.P.",
                "SMT. PROMILA BHALLA",
                "SHRI JAGDEEP KUMAR KAPOOR",
                "MS. ANJALI PANCHOLY",
                "DR PAWAN KUMAR",
                "SMT. ABHA AGARWAL",
                "SHRI SUDEEP ROY",
                "SHRI RAM SWAROOP MEENA",
                "DR ACHALA MEDIRATTA",
                "DR S.K. HUSSAIN",
                "SMT. JASMINE BIMRA MALLICK",
                "SHRI NITIN KUMAR AZAD",
                "MS D. BLESSY",
                "SHRI HARPAL SHASHIKANT DAVE",
                "SHRI BASKAR SELLAIYA",
                "SHRI ARVIND KAUSHIK",
                "SHRI LALIT MEHTA",
                "SMT. ASHA CHANDRA"
        };

        for(int i = 1; i< name.length; i++){
            Random r = new Random();
            int low = 20;
            int high = 60;
            int result = r.nextInt(high-low) + low;
            Employee emp = new Employee(i,name[i],result);
            this.Employees.add(emp);
        }

        return this.Employees;
    }


}