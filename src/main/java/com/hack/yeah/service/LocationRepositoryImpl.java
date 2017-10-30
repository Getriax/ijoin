package com.hack.yeah.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hack.yeah.dao.LocationRepository;

@Service
public class LocationRepositoryImpl{
	@Autowired
	LocationRepository locationRepository;
	
	
}
