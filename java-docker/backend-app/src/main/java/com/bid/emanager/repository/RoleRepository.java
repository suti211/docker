package com.bid.emanager.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bid.emanager.entity.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
	Role findByRole(String role);
}
