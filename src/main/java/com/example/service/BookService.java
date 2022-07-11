package com.example.service;

import java.util.List;

import com.example.entity.Book;

public interface BookService {

	public List<Book> findAllBooks();
	public List<Book> findAllvalidBooks();

	public List<Book> searchBooks(String keyword);

	public Book findBookById(Long id);

	public void createBook(Book book);

	public void updateBook(Book book);

	public void deleteBook(Long id);

	public void updateBookStatus(Long id);

}
