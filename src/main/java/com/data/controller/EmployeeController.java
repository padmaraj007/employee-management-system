package com.data.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.data.entity.Employee;
import com.data.services.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping("/saveEmployee")
	Employee saveEmployee(@RequestBody Employee employee) {
		Employee emp = employeeService.saveEmployee(employee);
		return emp;
	}

	@GetMapping("/getEmployee")
	List<Employee> getEmployee() {
		List<Employee> employeeList = employeeService.getEmployee();
		return employeeList;

	}

	@GetMapping("/getEmployeeById")
	Employee getEmployeeById(@RequestParam Long id) {
		Employee emp = employeeService.getEmployeeByID(id);
		return emp;

	}

	@GetMapping("/getEmployeeByFirstName")
	List<Employee> getEmployeeByFirstName(@RequestParam String firstName) {
		List<Employee> employeeList = employeeService.findByFirstName(firstName);
		return employeeList;

	}

	@GetMapping("/getEmployeeByDesignation")
	List<Employee> getEmployeeByDesignation(@RequestParam String designation) {
		List<Employee> employeeList = employeeService.findByDesignation(designation);
		return employeeList;

	}

	@GetMapping("/getEmployeeBySalaryRange")
	List<Employee> findSalaryBetween(@RequestParam double lowerSalaryLimit, @RequestParam double higherSalaryLimit) {
		return employeeService.findSalaryBetween(lowerSalaryLimit, higherSalaryLimit);

	}

	@GetMapping("/getEmployeeByDateOfJoining")
	List<Employee> findByDateOfJoining(@RequestParam String dateOfJoining) throws Exception {
		List<Employee> employeeList = employeeService.findByDateOfJoining(dateOfJoining);
		return employeeList;

	}
	
	@GetMapping("/getEmployeeByManagerId")
	List<Employee> findByManagerId(@RequestParam Long managerId){
		List<Employee> employeeList = employeeService.findByManagerId(managerId);
		return employeeList;
	}
	
	@GetMapping("/giveBonusToEmployee")
	public List<Employee> giveBonusToEmployee(@RequestParam Double bonus, String dateOfJoining) throws ParseException {
		List<Employee> employeeList = employeeService.giveBonusToEmployee(bonus, dateOfJoining);
		return employeeList;
		
	}
}
