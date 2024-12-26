package com.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.book.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, String> {
	
//	@Query(value = "select a from Author a where a.id=:authorId")
	@Query(value = "select a.* from authors a where a.au_id=:authorId", nativeQuery = true)
	public Author findByAuthorId(@Param(value = "authorId") String authorId);

}
