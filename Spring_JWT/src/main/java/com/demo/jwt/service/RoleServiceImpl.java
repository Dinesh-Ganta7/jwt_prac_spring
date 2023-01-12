package com.demo.jwt.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.jwt.dto.RoleDTO;
import com.demo.jwt.dto.UserDTO;
import com.demo.jwt.entity.Role;
import com.demo.jwt.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository roleRepository;

	@Override
	public boolean addRole(Role role) {

		try {
			roleRepository.save(role);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public RoleDTO getRole(RoleDTO roleDto) {

		RoleDTO roleDTO2 = RoleDTO.builder().build();

		Optional<Role> optionalRole = roleRepository.findByRoleName(roleDto.getRoleName());
		if (optionalRole.isPresent()) {
			BeanUtils.copyProperties(optionalRole.get(), roleDTO2);
			return roleDTO2;
		}
		return null;
	}

	@Override
	public List<RoleDTO> getRoles() {
		List<Role> roles = roleRepository.findAll();
		List<RoleDTO> roleDTOs = roles.stream().map((eachRole) -> {
			RoleDTO roleDto = RoleDTO.builder().build();
			BeanUtils.copyProperties(eachRole, roleDto);
			return roleDto;
		}).collect(Collectors.toList());
		return roleDTOs;

	}

}
