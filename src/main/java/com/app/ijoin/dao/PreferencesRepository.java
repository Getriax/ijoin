package com.app.ijoin.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.ijoin.model.Preferences;

@Repository
public interface PreferencesRepository extends JpaRepository<Preferences, Long> {
	@Query("SELECT p FROM Preferences p JOIN p.users u WHERE u.id = :uid")
	List<Preferences> findAllPreferencesByUserId(@Param("uid") Long uid);
	@Query("SELECT p FROM Preferences p WHERE lower(p.value) = lower(:val) ")
	Preferences findByValue(@Param("val") String val);
	
	
}
