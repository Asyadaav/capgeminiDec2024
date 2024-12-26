package com.book.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TitleDTO {

	@NotEmpty(message = "Id is manadatory")
	private String id;

	@NotEmpty(message = "Title is manadatory")
	private String title;

	@NotEmpty(message = "Type is manadatory")
	private String type;

	private Double price;

	private Double advance;

	private Integer royalty;

	private Integer ytdSales;

	private String notes;

	@NotNull(message = "PubDate is manadatory")
	private LocalDateTime pubDate;

}
