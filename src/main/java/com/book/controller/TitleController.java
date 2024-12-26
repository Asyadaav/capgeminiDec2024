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

import com.book.request.TitleDTO;
import com.book.request.TitleLinkAuthorRequest;
import com.book.response.TitleAddResponse;
import com.book.response.TitleAuthorLinkrResponse;
import com.book.response.TitleGetPublisherResponse;
import com.book.service.TitleService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/titles")
@Slf4j
public class TitleController {

	@Autowired
	private TitleService authorService;

	@PostMapping(path = "")
	public ResponseEntity<TitleAddResponse> addTitle(@RequestBody @Valid TitleDTO dto) {
		TitleAddResponse response = null;
		try {
			response = authorService.addTitle(dto);
		} catch (Exception e) {
			log.error("Error while adding titles -> ", e);
			return new ResponseEntity<TitleAddResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<TitleAddResponse>(response, HttpStatus.CREATED);
	}

	@PostMapping(path = "/{titleId}/authors")
	public ResponseEntity<TitleAuthorLinkrResponse> linkTitleWithAuthor(@PathVariable(value = "titleId") String titleId,
			@RequestBody @Valid TitleLinkAuthorRequest request) {
		TitleAuthorLinkrResponse author = null;
		try {
			author = authorService.linkTitleWithAuthor(titleId, request);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error while fetching authors -> ", e);
			return new ResponseEntity<TitleAuthorLinkrResponse>(author, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<TitleAuthorLinkrResponse>(author, HttpStatus.OK);
	}

	@PutMapping(path = "/{titleId}")
	public ResponseEntity<TitleAddResponse> updateTitle(@PathVariable(value = "titleId") String titleId,
			@RequestBody @Valid TitleDTO dto) {
		TitleAddResponse author = null;
		try {
			author = authorService.updateTitle(dto, titleId);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error while updating authors -> ", e);
			return new ResponseEntity<TitleAddResponse>(author, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<TitleAddResponse>(author, HttpStatus.OK);
	}

	@DeleteMapping(path = "/{titleId}")
	public ResponseEntity<TitleAddResponse> deleteAuthorById(@PathVariable(value = "titleId") String titleId) {
		TitleAddResponse author = null;
		try {
			author = authorService.deleteTitle(titleId);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error while deleting titles -> ", e);
			return new ResponseEntity<TitleAddResponse>(author, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<TitleAddResponse>(author, HttpStatus.OK);
	}

	@GetMapping(path = "/{publisherId}/titles")
	public ResponseEntity<TitleGetPublisherResponse> getAllTitlesOfPublisher(
			@PathVariable(value = "publisherId") String publisherId) {
		TitleGetPublisherResponse author = null;
		try {
			author = authorService.getAllTitlesOfPublisher(publisherId);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error while fetching titles by pubId -> ", e);
			return new ResponseEntity<TitleGetPublisherResponse>(author, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<TitleGetPublisherResponse>(author, HttpStatus.OK);
	}

}
