package com.demo.jwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.jwt.dto.RoleToUserForm;
import com.demo.jwt.dto.UserDTO;
import com.demo.jwt.entity.Role;
import com.demo.jwt.entity.User;
import com.demo.jwt.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	UserService userService;

	@PostMapping("/getUser")
	public ResponseEntity<?> getUser(@RequestBody UserDTO userDto) {
		UserDTO response = userService.getUser(userDto);
		if (response == null) {
			return new ResponseEntity<String>("User Not Found", HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<UserDTO>(response, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/getUsers")
	public ResponseEntity<List<UserDTO>> getUsers() {
		List<UserDTO> response = userService.getUsers();
		return new ResponseEntity<List<UserDTO>>(response, HttpStatus.OK);
	}

	@PostMapping("/register")
	public ResponseEntity<String> addUser(@RequestBody User user) {
		if (userService.addUser(user)) {
			return new ResponseEntity<String>("User Created Susccessfully!", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Something went wrong, failed to create user!", HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/addRoleToUser")
	public ResponseEntity<String> addRoleToUser(@RequestBody RoleToUserForm roleToUserForm) {
		if (userService.addRoleToUser(roleToUserForm.getUserEmail(), roleToUserForm.getRoleName())) {
			return new ResponseEntity<String>("Role Added to given user Successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Something went wrong, failed to create user!", HttpStatus.BAD_REQUEST);
		}
	}

}
