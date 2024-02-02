package com.connection.Employee.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HealthResponse {

	private int id;
	private String bloodGroup;
	private String gender;
	private int height;
}
