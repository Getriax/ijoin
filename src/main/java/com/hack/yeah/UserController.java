package com.hack.yeah;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hack.yeah.dao.PreferencesRespository;
import com.hack.yeah.dao.UserRepository;
import com.hack.yeah.model.Preferences;
import com.hack.yeah.model.User;
import com.hack.yeah.service.SecurityService;
import com.hack.yeah.service.UserService;
import com.hack.yeah.service.UserValidator;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private SecurityService securityService;

	
	@Autowired 
	UserRepository userRepository;
	
	@Autowired
	PreferencesRespository preferencesRepository;
	
	@Autowired
	private UserValidator userValidator;
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(Model model) {
		model.addAttribute("userForm", new User());
		return "registration";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(@ModelAttribute("userForm") User userForm, BindingResult res, Model model) {
		System.out.println(userForm);
		userValidator.validate(userForm, res);

		if (res.hasErrors())
			return "registration";

		userService.save(userForm);

		securityService.autologin(userForm.getUsername(), userForm.getPassword());

		return "redirect:/welcome";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("error", "ERROR");
		if (logout != null)
			model.addAttribute("logout", "logout");
		
		return "login";
	}
	@RequestMapping(value = "/{username}/more") 
	public String moreInfo(@PathVariable String username, Model model, Principal principal) {
		User user = userRepository.findByUsername(username);
		if (!user.getUsername().equals(principal.getName()))
			return "redirect:/login";
		model.addAttribute("user", user);
			return "more";		
		}
	
	@RequestMapping("/")
	public String redirect(Principal principal) {
		return "redirect:/"+principal.getName();
	}
	@RequestMapping("/{username}")
	public String welcome(@PathVariable String username, Model model, Principal principal) {
		if (username.isEmpty() && !principal.getName().isEmpty())
			return "redirect:/"+principal.getName();
		model.addAttribute("user", userRepository.findByUsername(username));
		if (!username.equals(principal.getName()))
			return "user";
		return "me";
	}
}
