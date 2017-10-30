package com.hack.yeah.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hack.yeah.model.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
	Location findByAddress(String address);
}
