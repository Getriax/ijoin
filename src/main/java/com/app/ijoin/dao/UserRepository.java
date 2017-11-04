package com.app.ijoin.dao;

import java.util.Set;

import com.app.ijoin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	User findByUsername(String username);
	User findByEmail(String email);
	@Query("SELECT u.id FROM User u WHERE u.username = :username")
	Long findIdOfUserByName(@Param("username") String username);
	@Query("SELECT u FROM User u JOIN u.preferences p WHERE u.username = :username AND p.value = :value")
	User findUserByPreferencesValue(@Param("username") String username, @Param("value" ) String value);
	@Query("SELECT u FROM User u LEFT JOIN u.preferences p WHERE p.value=:value")
	Set<User> findAllUsersByPreferencesValue(String value);
}
