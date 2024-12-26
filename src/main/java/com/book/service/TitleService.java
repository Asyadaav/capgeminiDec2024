package com.book.service;

import com.book.request.TitleDTO;
import com.book.request.TitleLinkAuthorRequest;
import com.book.response.TitleAddResponse;
import com.book.response.TitleAuthorLinkrResponse;
import com.book.response.TitleGetPublisherResponse;

public interface TitleService {

	public TitleAddResponse addTitle(TitleDTO title);

	public TitleAuthorLinkrResponse linkTitleWithAuthor(String titleId, TitleLinkAuthorRequest request);

	public TitleAddResponse updateTitle(TitleDTO updateDTO, String titleId);

	public TitleAddResponse deleteTitle(String titleId);

	public TitleGetPublisherResponse getAllTitlesOfPublisher(String titleId);

}
