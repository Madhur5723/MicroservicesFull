package com.connection.AddressService.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.connection.AddressService.entity.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, Integer> {

	@Query(nativeQuery = true, value="SELECT a.id,a.state,a.city,a.pincode FROM address a inner join employee e on a.id=e.id where a.id=:employeeId")

	Address findAddressByEmployeeId(@Param("employeeId") int employeeId);

}
	