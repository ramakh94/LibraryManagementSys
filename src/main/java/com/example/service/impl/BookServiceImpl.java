package com.example.service.impl;

import java.util.List;

import com.example.entity.Book;
import com.example.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.exception.NotFoundException;
import com.example.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	private final BookRepository bookRepository;

	public BookServiceImpl(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public List<Book> findAllBooks() {
		return bookRepository.findAll();
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public List<Book> findAllvalidBooks() {
		return bookRepository.findByEmptyTrue();
	}


	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public List<Book> searchBooks(String keyword) {
		if (keyword != null) {
			return bookRepository.search(keyword);
		}
		return bookRepository.findAll();
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public Book findBookById(Long id) {
		return bookRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(String.format("Book not found with ID %d", id)));
	}

	@Override
	public void createBook(Book book) {
		book.setEmpty(true);
		bookRepository.save(book);
	}

	@Override
	public void updateBook(Book book) {
		bookRepository.save(book);
	}

	@Override
	public void deleteBook(Long id) {
		final Book book = bookRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(String.format("Book not found with ID %d", id)));

		bookRepository.deleteById(book.getId());
	}

	@Override
	public void updateBookStatus(Long id) {
		final Book book = bookRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(String.format("Book not found with ID %d", id)));
		book.setEmpty(false);
		bookRepository.save(book);
	}


}
