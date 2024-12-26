package com.book.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
//@Builder
public class TitleLinkAuthorRequest {

	@NotEmpty(message = "Author Id is manadatory")
	private String authorId;

	@NotNull(message = "Royaltyper Id is manadatory")
	private Integer royaltyPer;

//	@NotNull(message = "Author Order is manadatory")
//	private Integer auOrd;

}
