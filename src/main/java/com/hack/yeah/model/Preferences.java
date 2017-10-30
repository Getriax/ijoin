package com.hack.yeah.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "preferences")
public class Preferences {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String value;

	@ManyToMany(mappedBy = "preferences")
	private Set<User> users;
	public Preferences() {
		// TODO Auto-generated constructor stub
	}
	public Preferences(String value, User user) {
		this.value = value;
		Set<User> userscp = new HashSet<>();
		userscp.add(user);
		this.users = userscp;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
	@Override
	public String toString() {
		users.forEach(System.out::println);
		return "Preferences [id=" + id + ", value=" + value + ", users=";
	}
	
	
}
