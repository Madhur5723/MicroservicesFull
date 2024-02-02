package com.connection.Employee.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.connection.Employee.FeignUtils.AddressFeign;
import com.connection.Employee.FeignUtils.HealthFeign;
import com.connection.Employee.Response.AddressResponse;
import com.connection.Employee.Response.EmployeeResponse;
import com.connection.Employee.Response.HealthResponse;
import com.connection.Employee.entity.Employee;
import com.connection.Employee.repo.EmployeeRepositary;
import com.connection.Employee.request.EmployeeResquest;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepositary er;

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private AddressFeign addressFeign;
	
	@Autowired
	private HealthFeign feign;

	public EmployeeResponse getEmployeeById(int id) {
		
		Employee employee = er.findById(id).get();
		
		EmployeeResponse employeeResponse = modelMapper.map(employee, EmployeeResponse.class);
		
		ResponseEntity<AddressResponse> addressResponseEntity = addressFeign.getAddressByEmployeeId(id);
		AddressResponse addressResponse = addressResponseEntity.getBody();
		employeeResponse.setAddressResponse(addressResponse);

		return employeeResponse;
	}
//	public Employee saveEmployee(Employee employee) {
//	return er.save(employee);
//}

	public EmployeeResponse saveEmployee(EmployeeResquest employeeResquest) {
		// emprequest--> map employee
		Employee employee = modelMapper.map(employeeResquest, Employee.class);
		// calling method to save
		Employee savedEmployee = er.save(employee);
		// employee --> map to employeeResponse
		EmployeeResponse savedEmployeeResponse = modelMapper.map(savedEmployee, EmployeeResponse.class);
		return savedEmployeeResponse;

	}

	public EmployeeResponse updateEmployee(EmployeeResquest employeeResquest) {
		Employee employee = modelMapper.map(employeeResquest, Employee.class);
		Employee updatedEmployee = er.save(employee);
		EmployeeResponse savedEmployee = modelMapper.map(updatedEmployee, EmployeeResponse.class);
		return savedEmployee;
	}

	public List<EmployeeResponse> getAllEmployeeDetails() {
		List<Employee> employees = er.findAll();
		List<EmployeeResponse> employeeResponse = employees.stream()
				.map(employee -> modelMapper.map(employee, EmployeeResponse.class)).collect(Collectors.toList());
		return employeeResponse;

	}

	public EmployeeResponse getEmployeeByHeatlhId(int id) {
		
		Employee employee = er.findEmployeeByHeathId(id).get();
		EmployeeResponse employeeResponse = modelMapper.map(employee, EmployeeResponse.class);
		ResponseEntity<HealthResponse> healthResponseEntity = feign.getHealthByAddressId(id);
		HealthResponse healthResponse = healthResponseEntity.getBody();
		employeeResponse.setHealthResponse(healthResponse);
		return employeeResponse;
		
	}

}
