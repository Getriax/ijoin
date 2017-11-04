package com.app.ijoin;

import java.io.IOException;
import java.security.Principal;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

import com.app.ijoin.dao.PreferencesRepository;
import com.app.ijoin.dao.UserRepository;
import com.app.ijoin.model.Preferences;
import com.app.ijoin.model.User;
import com.app.ijoin.service.GsonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.google.gson.Gson;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/rest")
public class RestCont {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PreferencesRepository preferencesRepository;
    AtomicLong atomicLong = new AtomicLong();
    @Autowired
    GsonService gsonService;

    @RequestMapping(value = "/getUserDetails/{username}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String getUserDetails(@PathVariable String username, Principal principal) {
        User user = userRepository.findByUsername(principal.getName());
        if (!username.equals(user.getUsername()))
            return "\"ERROR\" : \"Incorrect user name\"";
        System.out.println(user.getUsername());
        Map<String, Object> out = new HashMap<>();
        if (!user.getPreferences().isEmpty()) {
            ArrayList<String> values = new ArrayList<>();
            user.getPreferences().forEach(p -> values.add(p.getValue()));
            out.put("preferences", values);
        }
        if (user.getAbout() != null)
            out.put("about", user.getAbout());
        if (user.getLocation() != null)
            out.put("location", user.getLocation());
        out.forEach((s, o) -> System.out.println(s + " : " + o));
        Gson gson = gsonService.createGson();
        String serialized = gson.toJson(out);//gsonService.createJson(user.getPreferences(), user.getAbout(), user.getLocation());
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
    @RequestMapping(value = "/updateUser/{username}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String updateUser(@PathVariable(value = "username") String username,
                             @RequestParam("preferences") String preferences, @RequestParam("location") String address,
                             @RequestParam("about") String about, Principal principal, HttpServletResponse response) {


        Arrays.asList(preferences).forEach(System.out::println);
        User user = userRepository.findByUsername(principal.getName());

        //Wrong user is attempting to change someones preferences
        if (!username.equals(user.getUsername())) try {
            response.sendRedirect("/" + username);
        } catch (IOException e) {
            e.printStackTrace();
            return "Somethink went wrong with redirecting";
        }

        Set<Preferences> prefs;
        if (!preferences.isEmpty()) {
            prefs = new HashSet<>();
            for (String el : Arrays.asList(preferences.split("\\s+"))) {
                Preferences preferences1 = preferencesRepository.findByValue(el);
                if (preferences1 != null)
                    prefs.add(preferences1);
                else
                    return "Some preferences values aren't possible to store";
            }

            user.setPreferences(prefs);
        }
        else
            user.setPreferences(null);

        if (!about.isEmpty())
            user.setAbout(about);
//		if (!address.isEmpty())
//			user.setLocation(new Location(address));
        userRepository.save(user);

        return "You are updated!";
    }
}
