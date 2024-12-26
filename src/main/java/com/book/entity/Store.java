package com.book.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "stores")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Store {

	@Id
	@Column(name = "stor_id", length = 4)
	private String id;

	@Column(name = "stor_name", length = 40)
	private String name;

	@Column(name = "stor_address", length = 40)
	private String address;

	@Column(name = "city", length = 20)
	private String city;

	@Column(name = "state", length = 2)
	private String state;

	@Column(name = "zip", length = 5)
	private String zip;

//	@OneToMany(mappedBy = "store")
    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
//    @JsonManagedReference // Manages the relationship from parent side
    @JsonIgnore
	private List<Sale> sales;

}
