package com.book.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@Embeddable
//@Data
@EqualsAndHashCode
@AllArgsConstructor
public class TitleAuthorId implements Serializable {

	@Column(name = "au_id", length = 11)
	private String auId;

	@Column(name = "title_id", length = 10)
	private String titleId;

	// Equals and hashCode
}
