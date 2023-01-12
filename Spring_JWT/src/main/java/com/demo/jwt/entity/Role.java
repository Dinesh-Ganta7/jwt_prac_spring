package com.demo.jwt.entity;

import java.util.Collection;
import java.util.HashSet;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "role")
@Entity
public class Role {
	@Id
	int id;
	private String roleName;

	@ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
	private Collection<User> users = new HashSet<>();

}
