package com.app.ijoin.model;

import com.google.gson.annotations.Expose;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Location {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Expose
	private Long id;
	@Expose
	private String address;
	@Expose
	private Integer lat;
	@Expose
	private Integer lng;
	
	@OneToMany(mappedBy = "location")
	private Set<User> users;
	
	
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAddress() {
		return address.isEmpty() ? "" : address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getLat() {
		return lat;
	}
	public void setLat(Integer lat) {
		this.lat = lat;
	}
	public Integer getLng() {
		return lng;
	}
	public void setLng(Integer lng) {
		this.lng = lng;
	}

	@Override
	public String toString() {
		return "Location{" +
				"id=" + id +
				", address='" + address + '\'' +
				", lat=" + lat +
				", lng=" + lng +
				'}';
	}
}
