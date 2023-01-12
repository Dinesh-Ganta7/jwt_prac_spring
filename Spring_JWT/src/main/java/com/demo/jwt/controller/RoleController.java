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

import com.demo.jwt.dto.RoleDTO;
import com.demo.jwt.dto.UserDTO;
import com.demo.jwt.entity.Role;
import com.demo.jwt.service.RoleService;

@RestController
@RequestMapping("/api/role")
public class RoleController {

	@Autowired
	RoleService roleService;

	@PostMapping("/addRole")
	public ResponseEntity<String> addRole(@RequestBody Role role) {
		if (roleService.addRole(role)) {
			return new ResponseEntity<String>("Role Added Successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Something went wrong, failed to create user!", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/getRoles")
	public ResponseEntity<List<RoleDTO>> getRoles(){
		return new ResponseEntity<List<RoleDTO>>(roleService.getRoles(),HttpStatus.OK);
	}
	
	@PostMapping("/getRole")
	public ResponseEntity<RoleDTO> getUser(@RequestBody RoleDTO roleDto) {
		RoleDTO response = roleService.getRole(roleDto);
		return new ResponseEntity<RoleDTO>(response, HttpStatus.OK);
	}
	
	
	

}
