package com.book.entity;

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
@Table(name = "discounts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Discount {

	@Id
	@Column(name = "discounttype", length = 40)
	private String discountType;

	@ManyToOne
	@JoinColumn(name = "stor_id")
	@JsonIgnore
	private Store store;

	@Column(name = "lowqty")
	private Integer lowQty;

	@Column(name = "highqty")
	private Integer highQty;

	@Column(name = "discount")
	private Double discount;

}
