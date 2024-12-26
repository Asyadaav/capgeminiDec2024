package com.book.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "titleauthor")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TitleAuthor {

	@EmbeddedId
	private TitleAuthorId id;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("auId")
	@JoinColumn(name = "au_id")
//	@JsonBackReference
	@JsonIgnore
	private Author author;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("titleId")
	@JoinColumn(name = "title_id")
//	@JsonManagedReference
//	@JsonBackReference
	@JsonIgnore
	private Title title;

	@Column(name = "royaltyper")
	private Integer royaltyPer;

}
