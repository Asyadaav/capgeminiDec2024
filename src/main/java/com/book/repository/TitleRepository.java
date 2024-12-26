package com.book.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.book.entity.Title;

@Repository
public interface TitleRepository extends JpaRepository<Title, String> {

	@Query(value = "select t.* from titles t where t.title_id IN (:titleIds)", nativeQuery = true)
	public List<Title> findByTitles(@Param(value = "titleIds") List<String> titleIds);
	
	@Query(value = "select t.* from titles t where t.pub_id=:pudId", nativeQuery = true)
	public List<Title> findTitlesByPubliser(@Param(value = "pudId") String pudId);
}
