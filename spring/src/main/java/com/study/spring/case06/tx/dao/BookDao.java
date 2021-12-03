package com.study.spring.case06.tx.dao;

import com.study.spring.case06.tx.exception.InsufficientAmount;
import com.study.spring.case06.tx.exception.InsufficientQuantity;

public interface BookDao {
	// 這本書多少錢
	Integer getPrice(Integer bid);

	// 修改庫存資料
	Integer UpdateStock(Integer bid) throws InsufficientQuantity;

	// 修改錢包資料 money須扣除金額
	Integer UpdateWallet(Integer wid, Integer money) throws InsufficientAmount;

}
