package com.hack.yeah.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.hack.yeah.model.Location;
import com.hack.yeah.model.Preferences;

@Service
public class GsonService {
	
	public String createJson(Set<Preferences> preferences, String about, Location location) {
		Gson gson = new Gson();
		String resoult = "";
		if (!preferences.isEmpty())
			resoult += gson.toJson(preferences);
		if (!about.isEmpty())
			resoult += " " + gson.toJson(about);
		if (location != null)
			resoult += " " + gson.toJson(location);
		return resoult;
	}
}
