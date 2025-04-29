package com.example.library.LibraryManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.LibraryManagementSystem.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
