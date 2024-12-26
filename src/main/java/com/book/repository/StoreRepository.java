package com.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.entity.Store;

public interface StoreRepository extends JpaRepository<Store, String> {

}
