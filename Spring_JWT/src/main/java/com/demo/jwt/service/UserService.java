package com.demo.jwt.service;

import java.util.List;

import com.demo.jwt.dto.UserDTO;
import com.demo.jwt.entity.User;

public interface UserService {
	
	public UserDTO getUser(UserDTO userDto);
	
	public boolean addUser(User user);
	
	public List<UserDTO> getUsers();
	
    public boolean addRoleToUser(String username , String roleName);
	
	

}
