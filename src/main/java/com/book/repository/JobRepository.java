package com.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.entity.Job;

public interface JobRepository extends JpaRepository<Job, Integer> {

}
