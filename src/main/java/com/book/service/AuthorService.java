package com.book.service;

import com.book.request.AuthorDTO;
import com.book.request.AuthorUpdateDTO;
import com.book.response.AuthorAddResponse;
import com.book.response.AuthorGetResponse;

public interface AuthorService {

	public AuthorAddResponse addAuthor(AuthorDTO author);

	public AuthorGetResponse getAuthorById(String authorId);

	public AuthorAddResponse updateAuthor(AuthorUpdateDTO authorUpdateDTO, String authorId);

	public AuthorAddResponse deleteAuthor(String authorId);

	public AuthorGetResponse getAllTitlesOfAuthor(String authorId);

}
