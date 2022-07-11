package com.example.repository;

import java.util.List;

import com.example.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Long> {

	@Query("SELECT b FROM Book b  WHERE b.name LIKE %?1%" + " OR b.author LIKE %?1%" )
	public List<Book> search(String keyword);

	@Query("SELECT c FROM Book c WHERE c.empty = true")
	public List<Book> findByEmptyTrue();
}
