package com.hack.yeah.dao;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hack.yeah.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	User findByUsername(String username);
	User findByEmail(String email);
	@Query("SELECT u.id FROM User u WHERE u.username = :username")
	Long findIdOfUserByName(@Param("username") String username);
	@Query("SELECT u FROM User u JOIN u.preferences p WHERE u.username = :username AND p.value = :value")
	User findUsersByPreferencesValue(@Param("username") String username, @Param("value" ) String value);
	@Query("SELECT u FROM User u LEFT JOIN u.preferences p WHERE p.value=:value")
	Set<User> findAllUsersByPreferencesValue(String value);
}
