package com.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.entity.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, String> {

}
