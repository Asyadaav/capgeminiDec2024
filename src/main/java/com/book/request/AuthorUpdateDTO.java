package com.book.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AuthorUpdateDTO {

	@NotEmpty(message = "Last Name is manadatory")
	private String lastName;

	@NotEmpty(message = "First Name is manadatory")
	private String firstName;

	@NotEmpty(message = "Phone is manadatory")
	private String phone;

	private String address;

	private String city;

	private String state;

	private String zip;

	@NotNull(message = "Contract is manadatory")
	private Integer contract;
}
