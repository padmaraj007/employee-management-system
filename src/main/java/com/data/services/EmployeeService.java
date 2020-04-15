package com.data.services;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.data.entity.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);

	List<Employee> getEmployee();
	
	Employee getEmployeeByID(long id);

	List<Employee> findByFirstName(String firstName);

	List<Employee> findByDesignation(String designation);

	List<Employee> findSalaryBetween(double lowerSalaryLimit, double higherSalaryLimit);

	List<Employee> findByDateOfJoining(String dateOfJoining) throws Exception;
	
	List<Employee> findByManagerId(Long managerId);

	List<Employee> giveBonusToEmployee(Double bonus, String dateOfJoining) throws ParseException;



}
