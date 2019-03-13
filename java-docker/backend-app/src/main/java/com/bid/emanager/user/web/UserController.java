package com.bid.emanager.user.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bid.emanager.entity.User;
import com.bid.emanager.user.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/user")
@RequiredArgsConstructor(onConstructor= @__({ @Autowired }))
public class UserController {
	
	private final UserService userService;
	private final AuthenticationManager authenticationManager;
	
	@PostMapping("/register")
	public ResponseEntity register(@RequestBody UserDTO userDTO) {
		log.info("Register attempt with data: {}", userDTO);
		if (StringUtils.isAnyBlank(userDTO.getEmail(), userDTO.getFirstName(),
				userDTO.getLastName(), userDTO.getPassword(),
				userDTO.getRepeatPassword())) {
			return ResponseEntity.badRequest().build();
		}
		User user = userService.saveUser(userDTO);
		
		return user != null ? ResponseEntity.status(HttpStatus.CREATED).build() : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	@PostMapping("/signin")
	public ResponseEntity signIn(HttpServletRequest request, @RequestBody LoginDTO loginDto) {
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword());
		token.setDetails(new WebAuthenticationDetails(request));
		Authentication auth = authenticationManager.authenticate(token);
		if (auth.isAuthenticated()) {
			SecurityContextHolder.getContext().setAuthentication(auth);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
	
	@GetMapping("/getAuth")
	public ResponseEntity getAuth() {
		return ResponseEntity.ok(SecurityContextHolder.getContext().getAuthentication().getName());
	}
}
