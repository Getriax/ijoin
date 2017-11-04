package com.app.ijoin.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.Expose;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "preferences")
public class Preferences {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Expose
    private Long id;
    @Expose
    private String value;

    @JsonIgnore
    @ManyToMany(mappedBy = "preferences", cascade = CascadeType.ALL)
    private Set<User> users;

    public Preferences() {
        // TODO Auto-generated constructor stub
    }

    public Preferences(String value) {
        this.value = value;
    }
    //	public Preferences(String value, User user) {
//		this.value = value;
//		Set<User> userscp = new HashSet<>();
//		userscp.add(user);
//		this.users = userscp;
//	}

    public Preferences(String value, Set<User> users) {
        this.value = value;
        this.users = users;
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
        return "Preferences{" +
                "id=" + id +
                ", value='" + value +
                '}';
    }
}
