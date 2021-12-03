package com.study.spring.case06.tx.controller;

public interface BookController {
	//買書
	void buyBook(Integer wid,Integer bid);
	//買很多書
	void buyBooks(Integer wid,Integer... bids);
}
