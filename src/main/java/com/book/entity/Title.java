package com.book.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "titles")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Title {

	@Id
	@Column(name = "title_id", length = 10)
	private String id;

	@Column(name = "title", length = 80)
	private String title;

	@Column(name = "type", length = 12)
	private String type;

	@ManyToOne
	@JoinColumn(name = "pub_id")
//	@JsonBackReference
//	@JsonIgnore
	private Publisher publisher;

	@Column(name = "price")
	private Double price;

	@Column(name = "advance")
	private Double advance;

	@Column(name = "royalty")
	private Integer royalty;

	@Column(name = "ytd_sales")
	private Integer ytdSales;

	@Column(name = "notes", length = 200)
	private String notes;

	@Column(name = "pubdate")
	private LocalDateTime pubDate;

	@OneToMany(mappedBy = "title")
//	@JsonManagedReference
	@JsonIgnore
	private List<RoySched> royScheds;

	@OneToMany(mappedBy = "title")
//	@JsonManagedReference
	@JsonIgnore
	private List<TitleAuthor> titleAuthors;

	@OneToMany(mappedBy = "title")
//	@JsonManagedReference
	@JsonIgnore
	private List<Sale> sales;

}
