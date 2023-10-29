package com.example.demo;

import com.example.demo.Salary.Repo;
import com.example.demo.Salary.Salary;
import com.example.demo.service.ReportService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
@SpringBootApplication
public class DemoApplication {

	@Autowired
	private ReportService service;

	public DemoApplication(ReportService service){}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping(path = "/report")
	public Salary report(){

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

	@GetMapping("/report/s")
	public String generateReport() throws FileNotFoundException, JRException {
		return service.exportReport("pdf");
	}

	@GetMapping("/report/c")
	public String generateCommissionReport() throws FileNotFoundException, JRException{
		return service.exportCommissionReport("pdf");
	}

}
