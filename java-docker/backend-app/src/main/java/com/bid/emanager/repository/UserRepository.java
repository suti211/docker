package com.bid.emanager.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bid.emanager.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	@Query("SELECT u FROM User u where u.email = :email")
	Optional<User> findByEmail(@Param("email") String email);
}
