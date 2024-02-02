package com.empMang.Address.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.empMang.Address.entity.Address;

@Repository
public interface AddressRepositary extends JpaRepository<Address, Integer> {
	
	@Query(nativeQuery = true, value="SELECT a.id,a.lane1,a.lane2,a.state,a.pincode FROM address a join employee e on a.id=e.id where a.id=:employeeId")
	 Address findAddressByEmployeeId(@Param("employeeId") int employeeId);
}
