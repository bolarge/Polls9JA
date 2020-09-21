package com.corespecs.polls9ja.domain;

import javax.persistence.*;

import org.hibernate.annotations.Type;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="USERS")
public class User {

	@Id
	@GeneratedValue
	@Column(name="USER_ID")
	private Long id;
	
	@Column(name="USERNAME")
	@NotEmpty
	private String username;
	
	@Column(name="PASSWORD")
	@NotEmpty
	private String password;
	
	@Column(name="FIRST_NAME")
	@NotEmpty
	private String firstName;
	
	@Column(name="LAST_NAME")
	@NotEmpty
	private String lastName;

	@Column(name = "ENABLED")
	private Boolean enabled = false;

	@Column(name="ADMIN")
	@Type(type="yes_no") //DO NOT TYPE IN CAPS THE VALUE. MAKES HIBERNATE FAIL IN CREATION A SESSION
	private boolean admin = false;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.EAGER)
	private Set<Role> roles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@JsonIgnore
	public void addRole(String roleName) {
		if(this.roles == null) {
			this.roles = new HashSet<>();
		}
		Role role = new Role();
		role.setName(roleName);
		this.roles.add(role);
	}
	@Override
	public String toString() {
		return getId() + ", " + getUsername() + ", " + getFirstName() + ", " + getLastName();
	}
	
}
