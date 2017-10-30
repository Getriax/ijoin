package com.hack.yeah;

import java.security.Principal;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.hack.yeah.dao.PreferencesRespository;
import com.hack.yeah.dao.UserRepository;
import com.hack.yeah.model.Preferences;
import com.hack.yeah.model.User;
import com.hack.yeah.service.GsonService;

@RestController
@RequestMapping("/rest")
public class RestCont {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PreferencesRespository preferencesRespository;
	AtomicLong atomicLong = new AtomicLong();
	@Autowired
	GsonService gsonService;

	@RequestMapping(value = "/updateUser/{username}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String updateUser(@PathVariable(value = "username") String username,
			@RequestParam("preferences") String preferences, @RequestParam("location") String address,
			@RequestParam("about") String about, Principal principal) {
		System.out.println(username + " " + about + " " + address);
		Arrays.asList(preferences).forEach(System.out::println);
		User user = userRepository.findByUsername(principal.getName());
		if (!username.equals(user.getUsername()))
			return "\"ERROR\" : \"Incorrect user name\"";
		Set<Preferences> prefs = user.getPreferences();
		if (!prefs.isEmpty()) {
			preferencesRespository.delete(prefs);
		}
			if (!preferences.isEmpty()) {
				prefs = new HashSet<>();
				for(String el : Arrays.asList(preferences.split("\\s+")))
					prefs.add(new Preferences(el, user));
			}
			prefs.forEach(System.out::println);
			preferencesRespository.save(prefs);
			user.setAbout(about);
			userRepository.save(user);
		
		return "\"event\" : \"Changes made\"";
	}

	@RequestMapping(value = "/getUserDetails/{username}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getUserDetails(@PathVariable String username, Principal principal) {
		System.out.println("ADDDDDING");
		User user = userRepository.findByUsername(principal.getName());
		if (!username.equals(user.getUsername()))
			return "\"ERROR\" : \"Incorrect user name\"";

		Map<String, Object> out = new HashMap<>();
		if (!user.getPreferences().isEmpty())
			out.put("preferences", user.getPreferences());
		if (!user.getAbout().isEmpty())
			out.put("about", user.getAbout());
		if (user.getLocation() != null)
			out.put("location", user.getLocation());
		out.forEach((s, o) -> System.out.println(s + " : " + o));
		Gson gson = new Gson();
		String serialized = gson.toJson(out);
		System.out.println(serialized);
		return serialized;
	}
	//
	// @RequestMapping(value = "/getevents", method = RequestMethod.GET, produces =
	// MediaType.APPLICATION_JSON_VALUE)
	// public ArrayList<Event> getEvents(@RequestParam(value = "tag", defaultValue =
	// "", required = false) String tag,
	// Principal principal) {
	// Long id = userRepository.findIdOfUserByName(principal.getName());
	// System.out.println("USER ID " + id);
	// ArrayList<Event> events = new ArrayList<>();
	// if (tag.isEmpty())
	// events.addAll(eventRepository.findByUserId(id));
	// else
	// events.addAll(eventRepository.findByTagAndUser(id, tag));
	// System.out.println("IS EMTY " + events.isEmpty());
	// return events;
	// }
}
