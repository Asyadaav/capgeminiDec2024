package com.book.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TitleAddResponse {

	private String message;
	
	private String titleId;
}
