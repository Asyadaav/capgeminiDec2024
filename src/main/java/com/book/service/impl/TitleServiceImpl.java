package com.book.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.entity.Author;
import com.book.entity.Title;
import com.book.entity.TitleAuthor;
import com.book.entity.TitleAuthorId;
import com.book.repository.AuthorRepository;
import com.book.repository.TitleAuthorRepository;
import com.book.repository.TitleRepository;
import com.book.request.TitleDTO;
import com.book.request.TitleLinkAuthorRequest;
import com.book.response.TitleAddResponse;
import com.book.response.TitleAuthorLinkrResponse;
import com.book.response.TitleGetPublisherResponse;
import com.book.response.TitleGetResponse;
import com.book.service.TitleService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TitleServiceImpl implements TitleService {

	@Autowired
	private TitleRepository titleRepository;

	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private TitleAuthorRepository titleAuthorRepository;

	@Override
	public TitleAddResponse addTitle(TitleDTO dto) {
		Optional<Title> titleOpt = titleRepository.findById(dto.getId());
		if (titleOpt.isPresent()) {
			TitleAddResponse response = TitleAddResponse.builder().message("Duplicate Title ID").titleId(null).build();
			return response;
		}
		Title title = Title.builder().id(dto.getId()).title(dto.getTitle()).type(dto.getType()).price(dto.getPrice())
				.advance(dto.getAdvance()).royalty(dto.getRoyalty()).ytdSales(dto.getYtdSales()).notes(dto.getNotes())
				.pubDate(dto.getPubDate()).build();
		log.debug("Saving Title into DB" + title.toString());
		Title savedData = titleRepository.saveAndFlush(title);
		TitleAddResponse response = TitleAddResponse.builder().message("Title addedd successfully")
				.titleId(savedData.getId()).build();
		return response;
	}

	@Override
	public TitleAuthorLinkrResponse linkTitleWithAuthor(String titleId, TitleLinkAuthorRequest request) {
		Optional<Title> titleOpt = titleRepository.findById(titleId);
		if (titleOpt.isEmpty()) {
			return null;
		}
		Optional<Author> authorOpt = authorRepository.findById(request.getAuthorId());
		if (authorOpt.isEmpty()) {
			return null;
		}
		TitleAuthor titleAuthor = TitleAuthor.builder().id(new TitleAuthorId(request.getAuthorId(), titleId))
				.royaltyPer(request.getRoyaltyPer()).build();
		titleAuthorRepository.saveAndFlush(titleAuthor);

		TitleAuthorLinkrResponse response = TitleAuthorLinkrResponse.builder()
				.message("Author linked to title successfully.").titleId(titleId).authorId(request.getAuthorId())
				.build();
		return response;
	}

	@Override
	public TitleAddResponse updateTitle(TitleDTO dto, String titleId) {
		Optional<Title> titleOpt = titleRepository.findById(titleId);
		if (titleOpt.isEmpty()) {
			log.debug("Fetching data from DB" + titleOpt.get().toString());
			TitleAddResponse response = TitleAddResponse.builder().message("Invalid Title Id").titleId(null).build();
			return response;
		}
		Title title = titleOpt.get();
		title = Title.builder().title(dto.getTitle()).type(dto.getType()).price(dto.getPrice())
				.advance(dto.getAdvance()).royalty(dto.getRoyalty()).ytdSales(dto.getYtdSales()).notes(dto.getNotes())
				.pubDate(dto.getPubDate()).build();
		log.debug("Updating Title into DB" + title.toString());
		Title savedData = titleRepository.saveAndFlush(title);
		TitleAddResponse response = TitleAddResponse.builder().message("Title updated successfully")
				.titleId(savedData.getId()).build();

		return response;
	}

	@Override
	public TitleAddResponse deleteTitle(String titleId) {
		Optional<Title> titleOpt = titleRepository.findById(titleId);
		if (titleOpt.isEmpty()) {
			log.debug("Fetching data from DB" + titleOpt.get().toString());
			TitleAddResponse response = TitleAddResponse.builder().message("Invalid Title Id").titleId(null).build();
			return response;
		}
		titleRepository.deleteById(titleId);
		TitleAddResponse response = TitleAddResponse.builder().message("Title deleted successfully").titleId(titleId)
				.build();
		return response;
	}

	@Override
	public TitleGetPublisherResponse getAllTitlesOfPublisher(String pubId) {
		List<Title> titles = titleRepository.findTitlesByPubliser(pubId);
		if (titles == null) {
			return null;
		}
		List<TitleGetResponse> titlesResult = new ArrayList<>();
		titles.forEach(e -> {
			TitleGetResponse t = TitleGetResponse.builder().name(e.getTitle()).titleId(e.getId()).build();
			titlesResult.add(t);
		});
		TitleGetPublisherResponse response = TitleGetPublisherResponse.builder().publisherId(pubId).titles(titlesResult)
				.build();
		return response;
	}

}
