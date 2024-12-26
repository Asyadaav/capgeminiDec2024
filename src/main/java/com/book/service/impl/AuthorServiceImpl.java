package com.book.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.entity.Author;
import com.book.entity.Title;
import com.book.repository.AuthorRepository;
import com.book.repository.TitleAuthorRepository;
import com.book.repository.TitleRepository;
import com.book.request.AuthorDTO;
import com.book.request.AuthorUpdateDTO;
import com.book.response.AuthorAddResponse;
import com.book.response.AuthorGetResponse;
import com.book.service.AuthorService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private TitleAuthorRepository titleAuthorRepository;

	@Autowired
	private TitleRepository titleRepository;

	@Override
	public AuthorAddResponse addAuthor(AuthorDTO dto) {
		Optional<Author> authorOpt = authorRepository.findById(dto.getId());
		if (authorOpt.isPresent()) {
			AuthorAddResponse response = AuthorAddResponse.builder().message("Duplicate Author ID")
					.authorId(dto.getId()).build();
			return response;
		}
		Author author = Author.builder().id(dto.getId()).lastName(dto.getLastName()).firstName(dto.getFirstName())
				.phone(dto.getPhone()).address(dto.getAddress()).city(dto.getCity()).state(dto.getState())
				.zip(dto.getZip()).contract(dto.getContract()).build();
		log.debug("Saving Author into DB" + author.toString());
		Author savedData = authorRepository.saveAndFlush(author);
		AuthorAddResponse response = AuthorAddResponse.builder().message("Author added successfully.")
				.authorId(savedData.getId()).build();

		return response;
	}

	@Override
	public AuthorGetResponse getAuthorById(String authorId) {
		Optional<Author> authorOpt = authorRepository.findById(authorId);
		if (authorOpt.isEmpty()) {
			return null;
		}
		Author author = authorOpt.get();
		AuthorGetResponse response = AuthorGetResponse.builder().authorId(author.getId())
				.name(author.getFirstName() + " " + author.getLastName()).titles(new ArrayList<>()).build();
		return response;
	}

	@Override
	public AuthorAddResponse updateAuthor(AuthorUpdateDTO dto, String authorId) {
		Optional<Author> authorOpt = authorRepository.findById(authorId);
		if (authorOpt.isEmpty()) {
			log.debug("Fetching data from DB" + authorOpt.get().toString());
			AuthorAddResponse response = AuthorAddResponse.builder().message("Invalid Author Id").authorId(null)
					.build();
			return response;
		}

		Author author = authorOpt.get();
		author = Author.builder().lastName(dto.getLastName()).firstName(dto.getFirstName()).phone(dto.getPhone())
				.address(dto.getAddress()).city(dto.getCity()).state(dto.getState()).zip(dto.getZip())
				.contract(dto.getContract()).build();
		log.debug("Updating Author into DB" + author.toString());
		Author savedData = authorRepository.saveAndFlush(author);
		AuthorAddResponse response = AuthorAddResponse.builder().message("Author updated successfully.")
				.authorId(savedData.getId()).build();
		return response;
	}

	@Override
	public AuthorAddResponse deleteAuthor(String authorId) {
		Optional<Author> authorOpt = authorRepository.findById(authorId);
		if (authorOpt.isEmpty()) {
			log.debug("Fetching data from DB" + authorOpt.get().toString());
			AuthorAddResponse response = AuthorAddResponse.builder().message("Invalid Author Id").authorId(null)
					.build();
			return response;
		}
		authorRepository.deleteById(authorId);
		AuthorAddResponse response = AuthorAddResponse.builder().message("Author deleted successfully.")
				.authorId(authorId).build();
		return response;
	}

	@Override
	public AuthorGetResponse getAllTitlesOfAuthor(String authorId) {
		Optional<Author> authorOpt = authorRepository.findById(authorId);
		if (authorOpt.isEmpty()) {
			return null;
		}
		List<String> titleIds = titleAuthorRepository.findTitlesByAuthorId(authorId);
		List<Title> titles = titleRepository.findByTitles(titleIds);
		List<AuthorGetResponse> titleResponseList = new ArrayList<>();
		titles.forEach(e -> {
			AuthorGetResponse t = AuthorGetResponse.builder().authorId(e.getId()).name(e.getTitle()).build();
			titleResponseList.add(t);

		});
		Author author = authorOpt.get();
		AuthorGetResponse response = AuthorGetResponse.builder().authorId(author.getId())
				.name(author.getFirstName() + " " + author.getLastName()).titles(titleResponseList).build();

		return response;
	}

}
