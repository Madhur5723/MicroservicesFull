package com.connection.Employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.connection.Employee.Response.EmployeeResponse;
import com.connection.Employee.entity.Employee;
import com.connection.Employee.request.EmployeeResquest;
import com.connection.Employee.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@PostMapping("/save")
	public ResponseEntity<EmployeeResponse> saveEmployee(@RequestBody EmployeeResquest employeeResquest)
	{
		EmployeeResponse savedResponse=employeeService.saveEmployee(employeeResquest);
		return ResponseEntity.status(HttpStatus.OK).body(savedResponse);
	}
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<EmployeeResponse> getEmployeeDetails(@PathVariable("id") int id){
		
		EmployeeResponse employeeResponse=employeeService.getEmployeeById(id);
		return  ResponseEntity.status(HttpStatus.OK).body(employeeResponse);
		
	}
	//health calling api
	@GetMapping("/address/{id}")
	public ResponseEntity<EmployeeResponse> getEmployeeDetailsByHealth(@PathVariable("id") int id){
		
		EmployeeResponse employeeResponse=employeeService.getEmployeeByHeatlhId(id);
		return  ResponseEntity.status(HttpStatus.OK).body(employeeResponse);
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateEmployee(@RequestBody EmployeeResquest employeeResquest){
		EmployeeResponse updatedEmployee=employeeService.updateEmployee(employeeResquest);
		return ResponseEntity.status(HttpStatus.CREATED).body(updatedEmployee);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<?>> getAllEmployee(){
		List<EmployeeResponse> employeeDetails= employeeService.getAllEmployeeDetails();
		return ResponseEntity.status(HttpStatus.FOUND).body(employeeDetails);
	}
	
	
}
