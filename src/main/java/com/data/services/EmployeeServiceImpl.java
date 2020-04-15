package com.data.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.jboss.jandex.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entity.Employee;
import com.data.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee employee) {
		employee.setFullName(employee.getFirstName() + " " + employee.getLastName());
		Employee emp = employeeRepository.save(employee);
		return emp;
	}

	@Override
	public List<Employee> getEmployee() {
		List<Employee> emp = employeeRepository.findAll();
		return emp;
	}

	@Override
	public Employee getEmployeeByID(long id) {
		Employee emp = employeeRepository.findById(id).get();
		return emp;
	}

	public List<Employee> findByFirstName(String firstName) {
		List<Employee> emp = employeeRepository.findByFirstName(firstName);
		return emp;
	}

	@Override
	public List<Employee> findByDesignation(String designation) {
		List<Employee> emp = employeeRepository.findByDesignation(designation);
		return emp;
	}

	@Override
	public List<Employee> findByDateOfJoining(String dateOfJoining) throws Exception {
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		today = sdf.parse(dateOfJoining);
		List<Employee> emp = employeeRepository.findByDateOfJoining(today);
		return emp;

	}

	@Override
	public List<Employee> findSalaryBetween(double lowerSalaryLimit, double higherSalaryLimit) {
		return employeeRepository.findBySalaryBetween(lowerSalaryLimit, higherSalaryLimit);
	}

	@Override
	public List<Employee> findByManagerId(Long managerId) {
		return employeeRepository.findByManagerId(managerId);
	}

	@Override
	public List<Employee> giveBonusToEmployee(Double bonus, String dateOfJoining) throws ParseException {
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		today = sdf.parse(dateOfJoining);
		List<Employee> emp = employeeRepository.findByDateOfJoiningBefore(today);
		for (Employee empl : emp) {

			double tempbonus = bonus / 100 * empl.getSalary();

			empl.setBonus(tempbonus);

			employeeRepository.save(empl);
		}

		return emp;
	}

}