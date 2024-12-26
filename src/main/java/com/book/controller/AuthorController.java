package com.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.request.AuthorDTO;
import com.book.request.AuthorUpdateDTO;
import com.book.response.AuthorAddResponse;
import com.book.response.AuthorGetResponse;
import com.book.service.AuthorService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/authors")
@Slf4j
public class AuthorController {

	@Autowired
	private AuthorService authorService;

	@PostMapping(path = "")
	public ResponseEntity<AuthorAddResponse> addAuthors(@RequestBody @Valid AuthorDTO authorDTO) {
		AuthorAddResponse response = null;
		try {
			response = authorService.addAuthor(authorDTO);
		} catch (Exception e) {
			log.error("Error while fetching authors -> ", e);
			return new ResponseEntity<AuthorAddResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<AuthorAddResponse>(response, HttpStatus.CREATED);
	}

	@GetMapping(path = "/{authorId}")
	public ResponseEntity<AuthorGetResponse> getAuthorById(@PathVariable(value = "authorId") String authorId) {
		AuthorGetResponse author = null;
		try {
			author = authorService.getAuthorById(authorId);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error while fetching authors -> ", e);
			return new ResponseEntity<AuthorGetResponse>(author, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<AuthorGetResponse>(author, HttpStatus.CREATED);
	}

	@PutMapping(path = "/{authorId}")
	public ResponseEntity<AuthorAddResponse> updateAuthorById(@PathVariable(value = "authorId") String authorId,
			@RequestBody @Valid AuthorUpdateDTO dto) {
		AuthorAddResponse author = null;
		try {
			author = authorService.updateAuthor(dto, authorId);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error while updating authors -> ", e);
			return new ResponseEntity<AuthorAddResponse>(author, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<AuthorAddResponse>(author, HttpStatus.CREATED);
	}

	@DeleteMapping(path = "/{authorId}")
	public ResponseEntity<AuthorAddResponse> deleteAuthorById(@PathVariable(value = "authorId") String authorId) {
		AuthorAddResponse author = null;
		try {
			author = authorService.deleteAuthor(authorId);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error while fetching authors -> ", e);
			return new ResponseEntity<AuthorAddResponse>(author, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<AuthorAddResponse>(author, HttpStatus.CREATED);
	}

	@GetMapping(path = "/{authorId}/titles")
	public ResponseEntity<AuthorGetResponse> getAllTitlesWithAuthor(@PathVariable(value = "authorId") String authorId) {
		AuthorGetResponse author = null;
		try {
			author = authorService.getAllTitlesOfAuthor(authorId);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error while fetching authors -> ", e);
			return new ResponseEntity<AuthorGetResponse>(author, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<AuthorGetResponse>(author, HttpStatus.CREATED);
	}

//	@GetMapping(path = "/getAll")
//	public ResponseEntity<List<Author>> getAllAuthors() {
//		List<Author> response = null;
//		try {
//			response = authorRepository.findAll();
//		} catch (Exception e) {
//			log.error("Error while fetching authors -> ", e);
//			return new ResponseEntity<List<Author>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//		return new ResponseEntity<List<Author>>(response, HttpStatus.CREATED);
//	}
}
