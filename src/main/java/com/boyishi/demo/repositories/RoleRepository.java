package com.boyishi.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boyishi.demo.entities.Role;
import com.boyishi.demo.utilities.ERole;

public interface RoleRepository extends JpaRepository<Role, Long>{
	Optional<Role> findByName(ERole name);
}
