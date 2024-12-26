package com.book.response;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthorGetResponse {

	private String authorId;

	private String name;

	private String biography;

	private List<AuthorGetResponse> titles;
}
