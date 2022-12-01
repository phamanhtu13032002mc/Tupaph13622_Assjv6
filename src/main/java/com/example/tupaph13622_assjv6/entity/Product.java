package com.example.tupaph13622_assjv6.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "Products")
public class Product implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String name;
	String image;
	Double price;
	@Temporal(TemporalType.DATE)
	@Column(name = "createdata")
	Date createdata = new Date();
	Boolean available;;
	@ManyToOne
	@JoinColumn(name = "category_id")
	Category Categorys;
//	@OneToMany(mappedBy = "Products")
//	List<OrderDetail> Orderdetails;
}
