package com.book.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TitleGetResponse {

	private String titleId;

	private String name;
}
