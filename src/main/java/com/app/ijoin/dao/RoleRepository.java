package com.app.ijoin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.ijoin.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
