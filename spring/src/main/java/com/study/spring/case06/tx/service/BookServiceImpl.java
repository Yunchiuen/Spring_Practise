package com.study.spring.case06.tx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.spring.case06.tx.dao.BookDao;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookDao bookDao;

	@Override
	public void buyOne(Integer wid, Integer bid) {
		//這本書的價格
		int price=bookDao.getPrice(bid);
		//減去庫存
		bookDao.UpdateStock(bid);
		//錢包減去的金額
		bookDao.UpdateWallet(wid, price);
	}

	@Override
	public void buyMany(Integer wid, Integer... bids) {
		// TODO Auto-generated method stub

	}

}
