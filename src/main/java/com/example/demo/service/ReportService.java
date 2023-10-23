package com.example.demo.service;

import com.example.demo.Salary.Salary;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.*;


@Service
public class ReportService {

    public String exportReport(String reportFormat) throws JRException, FileNotFoundException {


        String userHome = System.getProperty("user.home");

        // Define the subdirectory where you want to save the report
        String reportDirectory = userHome + File.separator + "Desktop" + File.separator + "report";

        // Ensure the directory exists; if not, create it
        File directory = new File(reportDirectory);
        if (!directory.exists()) {
            directory.mkdirs(); // Create the directory and any necessary parent directories
        }

        // Now you have the full path to the report file
        String reportPath = reportDirectory + File.separator + "employees";



        Salary salary = new Salary();
        salary.setName("John");
        salary.setPin("30");
        salary.setDepartment("SE");
        salary.setDesignation("Software Engineer");

        salary.setIncomeYear("2024");
        salary.setDoj("21-2-23");
        salary.setAssesmentYear("2023");
        salary.setTinNumber("1234567886");

        List<Salary> salaryList = new ArrayList<>();
        salaryList.add(salary);

        File file = ResourceUtils.getFile("classpath:salary.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(salaryList);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Java Techie");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        if (reportFormat.equalsIgnoreCase("html")) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, reportPath + "/employees.html");
        }
        if (reportFormat.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(jasperPrint, reportPath + "/employees.pdf");
        }

        return "report generated in path : " + reportPath;

    }

}
