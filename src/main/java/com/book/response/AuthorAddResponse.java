package com.book.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthorAddResponse {

	private String message;
	
	private String authorId;
}
