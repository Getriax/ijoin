package com.app.ijoin.service;

import java.util.List;

import com.app.ijoin.dao.PreferencesRepository;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.ijoin.model.Preferences;



public class PreferencesServiceIml {
	@Autowired
    PreferencesRepository preferencesRepository;
	

	public List<Preferences> findAll() {
		return preferencesRepository.findAll();
	}
	public List<Preferences> findByUserId(Long uid) {
		return preferencesRepository.findAllPreferencesByUserId(uid);
	}
}
