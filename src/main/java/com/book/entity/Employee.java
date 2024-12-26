package com.book.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

	@Id
	@Column(name = "emp_id", length = 9)
	private String id;

	@Column(name = "fname", length = 20)
	private String firstName;

	@Column(name = "minit", length = 1)
	private String middleInitial;

	@Column(name = "lname", length = 30)
	private String lastName;

	@ManyToOne
	@JoinColumn(name = "job_id")
//	@JsonBackReference
	@JsonIgnore
	private Job job;

	@ManyToOne
	@JoinColumn(name = "pub_id")
//	@JsonBackReference
	@JsonIgnore
	private Publisher publisher;

	@Column(name = "hire_date")
	private LocalDateTime hireDate;

}