package com.hack.yeah.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hack.yeah.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
