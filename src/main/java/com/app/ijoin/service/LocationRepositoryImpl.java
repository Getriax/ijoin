package com.app.ijoin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.ijoin.dao.LocationRepository;

@Service
public class LocationRepositoryImpl{
	@Autowired
	LocationRepository locationRepository;
	
	
}
