package com.hack.yeah.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hack.yeah.model.Preferences;

@Repository
public interface PreferencesRespository extends JpaRepository<Preferences, Long> {
	@Query("SELECT p FROM Preferences p JOIN p.users u WHERE u.id = :uid")
	List<Preferences> findAllPreferencesByUserId(@Param("uid") Long uid);
	//@Query("SELECT p FROM Preferences p WHERE p.value := value")
	Preferences findByValue(String value);
	
	
}
