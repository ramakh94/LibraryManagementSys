package com.example.controller;

import com.example.entity.Book;
import com.example.entity.Rent;
import com.example.service.BookService;
import com.example.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@Controller
public class IndexController {

	private final BookService bookService;
	private final RentService rentService;
	@Autowired
	public IndexController(BookService bookService,RentService rentService) {
		this.bookService = bookService;
		this.rentService = rentService;
	}

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("books", bookService.findAllvalidBooks());
		return "redirect:/login";

	}

	@GetMapping("/rentPage")
	public String listed(Model model) {
		model.addAttribute("books", bookService.findAllvalidBooks());
		return "rent-page";

	}


	@RequestMapping("/rents")
	public String findAllrent(Model model) {
		final List<Rent> rents = rentService.findAllRent();
		model.addAttribute("rents", rents);
		return "list-rents";
	}
	@GetMapping("/addrent")
	public String showRentForm(Rent rent, Model model) {
		model.addAttribute("books", bookService.findAllvalidBooks());

		return "add-rent";
	}



	@RequestMapping("/add-rent")
	public String createRent(Rent rent, BindingResult result, Model model) {
		System.out.println();
		if (result.hasErrors()) {
			System.out.println(result);
			return "add-rent";
		}
		System.out.println(rent.getCustomer());
		bookService.updateBookStatus(rent.getBooks().getId());
		rentService.createRent(rent);
		model.addAttribute("rent", rentService.findAllRent());
		return "redirect:/rentPage";
	}

	@RequestMapping("/searchUser")
	public String findAllByCustomer(@Param("customer") String customer, Model model) {
		final List<Rent> rents = rentService.findAllRentByCustomer(customer);
		System.out.println("//////////rents "+rents);
		System.out.println("customer "+customer);
		model.addAttribute("rents", rents);
		model.addAttribute("customer", customer);
		return "list-for-cust";
	}

	@RequestMapping("/searchDate")
	public String findAllByDate(@Param("date") String date, Model model) {
		final List<Rent> rents = rentService.findAllRentByDate(date);
		System.out.println("//////////rents "+rents);
		System.out.println("date "+date);
		model.addAttribute("rents", rents);
		model.addAttribute("date", date);
		return "list-rents";
	}

}
