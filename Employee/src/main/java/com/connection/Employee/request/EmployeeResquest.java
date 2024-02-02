package com.connection.Employee.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResquest {
	
	private int id;
	private String name;
	private String email;
	private String deptartment;

}
