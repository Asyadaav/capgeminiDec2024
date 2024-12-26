package com.book.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.book.entity.Title;
import com.book.entity.TitleAuthor;

@Repository
public interface TitleAuthorRepository extends JpaRepository<TitleAuthor, String> {

	@Query(value = "select title_id from titleauthor where au_id=:authorId", nativeQuery = true)
	public List<String> findTitlesByAuthorId(@Param(value = "authorId") String authorId);
}
