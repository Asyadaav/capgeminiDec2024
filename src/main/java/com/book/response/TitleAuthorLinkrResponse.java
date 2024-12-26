package com.book.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TitleAuthorLinkrResponse {

	private String authorId;
	
	private String titleId;

	private String message;

}
