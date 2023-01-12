package com.demo.jwt.service;

import java.util.List;

import com.demo.jwt.dto.RoleDTO;
import com.demo.jwt.entity.Role;

public interface RoleService {
	
	public boolean addRole(Role role);
	
	public RoleDTO getRole(RoleDTO roleDto);
	
	public List<RoleDTO> getRoles();

}
