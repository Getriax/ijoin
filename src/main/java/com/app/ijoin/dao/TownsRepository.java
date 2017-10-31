package com.app.ijoin.dao;

import org.springframework.data.jpa.repository.Query;

public interface TownsRepository {
	@Query("SELECT t.nazwa FROM t Twons WHERE t.nazwa LIKE :nazwa")
	String findTwonsByName(String name);
}
