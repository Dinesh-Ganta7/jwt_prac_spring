package com.demo.jwt.dto;

import java.util.Collection;

import com.demo.jwt.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoleDTO {
	int id;
	private String roleName;

}
