package com.example.demo.Salary;

import java.util.ArrayList;
import java.util.List;

public class Repo {
    public static Salary getInfo(){
            Salary salary = new Salary();
            salary.setName("John");
            salary.setPin("30");
            salary.setDepartment("SE");
            salary.setDesignation("Software Engineer");

            salary.setIncomeYear("2024");
            salary.setDoj("21-2-23");
            salary.setAssesmentYear("2023");
            salary.setTinNumber("1234567886");
            return salary;
        }


}
