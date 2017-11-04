package com.app.ijoin.service;

import java.util.Set;

import com.app.ijoin.model.Preferences;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.app.ijoin.model.Location;

@Service
public class GsonService {
	
	public String createJson(Set<Preferences> preferences, String about, Location location) {
		Gson gson = createGson();
		String resoult = "";
		if (!preferences.isEmpty())
			resoult += gson.toJson(preferences);
		if (!about.isEmpty())
			resoult += " " + gson.toJson(about);
		if (location != null)
			resoult += " " + gson.toJson(location);
		return resoult;
	}
	public Gson createGson() {
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
		return gson;
	}
}
