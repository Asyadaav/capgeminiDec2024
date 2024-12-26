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
@Table(name = "jobs")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Job {

	@Id
	@Column(name = "job_id")
	private Integer id;

	@Column(name = "job_desc", length = 50)
	private String description;

	@Column(name = "min_lvl")
	private Integer minLevel;

	@Column(name = "max_lvl")
	private Integer maxLevel;

	@OneToMany(mappedBy = "job", cascade = CascadeType.ALL)
//	@JsonManagedReference // Manages the relationship from parent side
	@JsonIgnore
	private List<Employee> employees;

}
