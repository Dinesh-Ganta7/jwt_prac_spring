package com.demo.jwt.dto;

import java.util.Collection;
import java.util.HashSet;

import com.demo.jwt.entity.Role;
import com.demo.jwt.entity.User;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {

	private int id;
	private String firstName;
	private String LastName;
	private String email;
	private Collection<Role> roles;

}
