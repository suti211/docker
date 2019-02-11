package com.bid.emanager.user.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bid.emanager.entity.User;
import com.bid.emanager.user.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor(onConstructor= @__({ @Autowired }))
public class UserController {
	
	private final UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity register(@RequestBody UserDTO userDTO) {
		User user = userService.saveUser(userDTO);
		
		return user != null ? ResponseEntity.status(HttpStatus.CREATED).build() : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
}
