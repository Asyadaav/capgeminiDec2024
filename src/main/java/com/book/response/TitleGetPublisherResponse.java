package com.book.response;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TitleGetPublisherResponse {

	private String publisherId;

	private List<TitleGetResponse> titles;

}
