package com.bid.emanager.user;

import com.bid.emanager.entity.User;
import com.bid.emanager.user.web.UserDTO;

public interface UserService {
	User findUserByEmail(String email);
	User saveUser(UserDTO userDTO);
}
