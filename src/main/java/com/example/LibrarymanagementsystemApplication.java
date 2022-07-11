package com.example;

import com.example.common.Constants;
import com.example.entity.*;
import com.example.service.BookService;
import com.example.service.RentService;
import com.example.service.impl.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class LibrarymanagementsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibrarymanagementsystemApplication.class, args);
	}

	@Bean
	public CommandLineRunner initialCreate(BookService bookService, RentService rentService, UserService userService) {
		return (args) -> {

			userService.addNew(new User("Mr. Admin", "admin", "admin", Constants.ROLE_ADMIN,false));
			userService.addNew(new User("Mr. user", "user", "user", Constants.ROLE_USER,false));

			Book book = new Book("Test isbn", "Test name", "Test serial name", "Test description",true,"author1","Cat");
//			Author author = new Author("Test author name", "Test description");
//			Category category = new Category("Test category name");

//			book.addAuthors(author);
//			book.addCategories(category);

			bookService.createBook(book);

			Book book1 = new Book("Test isbn1", "Test name1", "Test serial name1", "Test description1",false,"author1","Cat1");
//			Author author1 = new Author("Test author name1", "Test description1");
//			Category category1 = new Category("Test category name1");

//			book1.addAuthors(author1);
//			book1.addCategories(category1);

			bookService.createBook(book1);

			Book book2 = new Book("Test isbn2", "Test name2", "Test serial name2", "Test description2",true,"author2","Cat2");
//			Author author2 = new Author("Test author name2", "Test description2");
//			Category category2 = new Category("Test category name2");

//			book2.addAuthors(author2);
//			book2.addCategories(category2);

			bookService.createBook(book2);

			Rent rent1=new Rent("name1","contact1", "1/1/1133",3,book1);

			rentService.createRent(rent1);
		};
	}
}
