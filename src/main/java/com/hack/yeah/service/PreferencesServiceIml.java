package com.hack.yeah.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hack.yeah.dao.PreferencesRespository;
import com.hack.yeah.model.Preferences;



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
