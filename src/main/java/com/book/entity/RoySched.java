package com.book.entity;

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
@Table(name = "roysched")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoySched {

	@Id
	@Column(name = "roysched_id")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "title_id")
//	@JsonBackReference
	@JsonIgnore
	private Title title;

	@Column(name = "lorange")
	private Integer lowerRange;

	@Column(name = "hirange")
	private Integer higherRange;

	@Column(name = "royalty")
	private Integer royalty;

}
