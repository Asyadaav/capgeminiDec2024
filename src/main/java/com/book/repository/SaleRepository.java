package com.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.entity.Sale;

public interface SaleRepository extends JpaRepository<Sale, String> {

}
