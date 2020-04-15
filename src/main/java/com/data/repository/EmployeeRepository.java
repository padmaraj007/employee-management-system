package com.data.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.data.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	List<Employee> findByFirstName(String firstName);

	List<Employee> findByDesignation(String designation);

	List<Employee> findBySalaryBetween(double lowerSalaryLimit, double higherSalaryLimit);

	List<Employee> findByDateOfJoining(Date dateOfJoining);

	List<Employee> findByManagerId(Long managerId);

	@Query("select e from Employee e where e.dateOfJoining >= :dateOfJoining")
	List<Employee> findByDateOfJoiningBefore(@Param("dateOfJoining") Date dateOfJoining);

}
