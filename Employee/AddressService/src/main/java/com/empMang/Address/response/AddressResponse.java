package com.empMang.Address.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressResponse {
	
	private int id;
	private String lane1;
	private String lane2;
	private String pincode;
	private String state;
	

}
