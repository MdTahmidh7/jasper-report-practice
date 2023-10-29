package com.example.demo.service;

import com.example.demo.Commission;
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


    public String exportCommissionReport(String reportFormat) throws JRException, FileNotFoundException {

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

        Commission commission = new Commission();
        commission.setDate(LocalDate.now());
        commission.setWalletType("Bkash");
        commission.setWalletShortCode("12");
        commission.setWalletNumber("01967502298");
        commission.setAmount("100");
        commission.setComment("Disbursed");



        Commission commission1 = new Commission();
        commission1.setDate(LocalDate.now());
        commission1.setWalletType("Nogod");
        commission1.setWalletShortCode("2");
        commission1.setWalletNumber("01787502298");
        commission1.setAmount("1000");
        commission1.setComment("Disbursed");

        Commission commission2 = new Commission();
        commission2.setDate(LocalDate.now());
        commission2.setWalletType("Nogod");
        commission2.setWalletShortCode("2");
        commission2.setWalletNumber("01787502298");
        commission2.setAmount("1000");
        commission2.setComment("Disbursed");

        Commission commission3 = new Commission();
        commission3.setDate(LocalDate.now());
        commission3.setWalletType("Nogod");
        commission3.setWalletShortCode("2");
        commission3.setWalletNumber("01787502298");
        commission3.setAmount("1000");
        commission3.setComment("Disbursed");


        List<Commission> commissionList = new ArrayList<>();
        commissionList.add(commission);
        commissionList.add(commission1);
        commissionList.add(commission2);
        commissionList.add(commission3);
        commissionList.add(commission1);
        commissionList.add(commission2);
        commissionList.add(commission3);


        File file = ResourceUtils.getFile("classpath:commission.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(commissionList);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("from","1-1-2020");
        parameters.put("to","1-31-2020");
        parameters.put("createdBy", "Abdullah-Al-Tahmid");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        if (reportFormat.equalsIgnoreCase("html")) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, reportPath + "/commission.html");
        }
        if (reportFormat.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(jasperPrint, reportPath + "/commission.pdf");
        }

        return "report generated in path : " + reportPath;
    }

}
