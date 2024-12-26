package com.book.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "authors")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Author {

    @Id
    @Column(name = "au_id", length = 11)
    private String id;

    @Column(name = "au_lname", length = 40)
    private String lastName;

    @Column(name = "au_fname", length = 20)
    private String firstName;

    @Column(name = "phone", length = 12)
    private String phone;

    @Column(name = "address", length = 40)
    private String address;

    @Column(name = "city", length = 20)
    private String city;

    @Column(name = "state", length = 2)
    private String state;

    @Column(name = "zip", length = 5)
    private String zip;

    @Column(name = "contract")
    private Integer contract;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
	@JsonIgnore
//    @JsonManagedReference // Manages the relationship from parent side
    private List<TitleAuthor> titleAuthors;

}