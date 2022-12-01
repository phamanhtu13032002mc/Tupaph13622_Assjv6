package com.example.tupaph13622_assjv6.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;


@Data
@Entity
@Table(name = "categorys")
public class  Category implements Serializable {
	@Id
	String id;
	String name;
	@JsonIgnore
	@OneToMany(mappedBy = "Categorys")
	List<Product> Product;
}
