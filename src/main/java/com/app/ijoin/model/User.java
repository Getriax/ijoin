package com.app.ijoin.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.Expose;

import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name = "user")
public class User {
	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Expose
	private String username;
	@Expose
	private String email;
	@Expose
	private String password;
	@Expose
	private String about;
	@Transient
	private String confirmPassword;
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_preferences", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "preferences_id"))
	private Set<Preferences> preferences;
	@ManyToOne
	@JoinColumn(name = "location_id")
	private Location location;

	public User() {
	}


	public User(String username) {
		this.username = username;
	}

	public User(String username, Set<Preferences> preferences) {
		this.username = username;
		this.preferences = preferences;
	}


	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Set<Preferences> getPreferences() {
		return preferences;
	}
	public void setPreferences(Set<Preferences> preferences) {
		this.preferences = preferences;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", username='" + username + '\'' +
				", email='" + email + '\'' +
				", password='" + password + '\'' +
				", about='" + about + '\'' +
				", confirmPassword='" + confirmPassword + '\'' +
				", location=" + location.getAddress() +
				'}';
	}
}
