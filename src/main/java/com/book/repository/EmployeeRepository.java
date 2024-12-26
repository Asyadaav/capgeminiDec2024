package com.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

}
