package com.demo.jwt.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.jwt.dto.UserDTO;
import com.demo.jwt.entity.Role;
import com.demo.jwt.entity.User;
import com.demo.jwt.repository.RoleRepository;
import com.demo.jwt.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;

	@Override
	public UserDTO getUser(UserDTO userDto) {
		System.out.println(userDto);
		UserDTO userDTO2 = UserDTO.builder().build();
		Optional<User> userOptional = userRepository.findByEmail(userDto.getEmail());
		if (userOptional.isPresent()) {
            System.out.println(userOptional.get());
			BeanUtils.copyProperties(userOptional.get(), userDTO2);
			return userDTO2;
		}
		return null;
	}

	@Override
	public boolean addUser(User user) {

		try {

			userRepository.save(user);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public List<UserDTO> getUsers() {

		List<User> users = userRepository.findAll();
		List<UserDTO> userDTOs = users.stream().map((eachUser) -> {
			UserDTO userDto = new UserDTO();
			BeanUtils.copyProperties(eachUser, userDto);
			return userDto;
		}).collect(Collectors.toList());
		return userDTOs;
	}

	@Override
	@Transactional
	public boolean addRoleToUser(String email, String roleName) {
		try {
			User user = userRepository.findByEmail(email).get();
			Role role = roleRepository.findByRoleName(roleName).get();
			user.getRoles().add(role);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

}
