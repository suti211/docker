package com.bid.emanager.user;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bid.emanager.entity.Role;
import com.bid.emanager.entity.User;
import com.bid.emanager.repository.RoleRepository;
import com.bid.emanager.repository.UserRepository;
import com.bid.emanager.user.web.UserDTO;
import com.bid.emanager.validators.UserValidator;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(onConstructor=@__({ @Autowired }))
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	private final BCryptPasswordEncoder encoder;
	private final UserValidator userValidator;
	
	@Override
	public User saveUser(UserDTO userDTO) {
		
		User checkUser = findUserByEmail(userDTO.getEmail());
		if (checkUser != null) {
			return null;
		}
		
		if (userValidator.validateUser(userDTO)) {
			User user = User.builder()
					.firstName(userDTO.getFirstName())
					.lastName(userDTO.getLastName())
					.password(userDTO.getPassword())
					.email(userDTO.getEmail())
					.active(0)
					.accountExpired(0)
					.credentialsExpired(0)
					.build();
			Role role = roleRepository.findByRole("ROLE_USER");
			user.setPassword(encoder.encode(user.getPassword()));
			user.setRoles(new HashSet<>(Arrays.asList(role)));
			return userRepository.save(user);
		} else {
			return null;
		}
	}

	@Override
	public User findUserByEmail(String email) {
		Optional<User> user = userRepository.findByEmail(email); 
		return user.isPresent() ? user.get() : null;
	}
}
