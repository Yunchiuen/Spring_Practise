package com.study.spring.case06.tx.service;

public interface BookService {
	//買一本	
	void buyOne(Integer wid,Integer bid);//錢包(使用者wid)要買哪一本書bid
	//買很多本
	void buyMany(Integer wid,Integer... bids);
	
}
