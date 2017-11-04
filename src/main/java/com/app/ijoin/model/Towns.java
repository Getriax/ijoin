package com.app.ijoin.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Towns {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nazwa;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNazwa() {
		return nazwa;
	}
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	@Override
	public String toString() {
		return "Towns{" +
				"id=" + id +
				", nazwa='" + nazwa + '\'' +
				'}';
	}
}
