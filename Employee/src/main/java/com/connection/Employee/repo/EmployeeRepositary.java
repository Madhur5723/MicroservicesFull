package com.connection.Employee.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.connection.Employee.entity.Employee;

@Repository
public interface EmployeeRepositary extends JpaRepository<Employee, Integer>  {

	Optional<Employee> findEmployeeByHeathId(int id);

}
