package com.example.tupaph13622_assjv6.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "orderdetails", uniqueConstraints = { @UniqueConstraint(columnNames = { "productid", "oderid" }) })
public class OrderDetail implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	Double price;
	Integer quantity;
	Integer status;
	@ManyToOne
	@JoinColumn(name = "productid")
	Product product;
	@ManyToOne
	@JoinColumn(name = "oderid")
	Order order;
}
