package com.example.HealthService.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.HealthService.entity.Health;

@Repository
public interface HealthRepositary extends JpaRepository<Health, Integer> {

	@Query(nativeQuery = true,value ="Select h.id,h.blood_group,h.gender,h.height from health h inner join address a on a.id=h.id where h.id=:addressId" )
	Health findHealthByAddressId(@Param("addressId") int addressId);

}
