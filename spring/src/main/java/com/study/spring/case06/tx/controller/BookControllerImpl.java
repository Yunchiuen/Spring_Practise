package com.study.spring.case06.tx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.study.spring.case06.tx.service.BookService;

@Controller
public class BookControllerImpl implements BookController {
	@Autowired
	private BookService bookService;

	@Override
	public void buyBook(Integer wid, Integer bid) {
		bookService.buyOne(wid, bid);
		System.out.println("buyBook ok");
	}

	@Override
	public void buyBooks(Integer wid, Integer... bids) {
		// TODO Auto-generated method stub

	}

}
