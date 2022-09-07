package com.example.tupaph13622_assjv6.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "authorities", uniqueConstraints = { @UniqueConstraint(columnNames = { "username", "rolesid" }) })
public class Authority {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "username")
	Account account;
	@ManyToOne
	@JoinColumn(name = "rolesid")
    Role role;
}
