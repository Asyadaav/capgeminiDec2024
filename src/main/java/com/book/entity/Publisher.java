package com.book.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "publishers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Publisher {

	@Id
	@Column(name = "pub_id", length = 4)
	private String id;

	@Column(name = "pub_name", length = 40)
	private String name;

	@Column(name = "city", length = 20)
	private String city;

	@Column(name = "state", length = 2)
	private String state;

	@Column(name = "country", length = 30)
	private String country;

//	@OneToMany(mappedBy = "publisher")
//	@JsonBackReference
	@OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL)
//    @JsonManagedReference // Manages the relationship from parent side
	@JsonIgnore
	private List<Title> titles;

	@OneToMany(mappedBy = "publisher")
//	@JsonManagedReference
	@JsonIgnore
	private List<Employee> employees;

}
