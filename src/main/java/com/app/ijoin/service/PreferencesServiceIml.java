package com.app.ijoin.service;

import java.util.List;

import com.app.ijoin.dao.PreferencesRespository;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.ijoin.model.Preferences;



public class PreferencesServiceIml {
	@Autowired
    PreferencesRespository preferencesRespository;
	

	public List<Preferences> findAll() {
		return preferencesRespository.findAll();
	}
	public List<Preferences> findByUserId(Long uid) {
		return preferencesRespository.findAllPreferencesByUserId(uid);
	}
}
