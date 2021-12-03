package com.study.spring.case06.tx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.study.spring.case06.tx.exception.InsufficientAmount;
import com.study.spring.case06.tx.exception.InsufficientQuantity;

@Repository
public class BookDaoImpl implements BookDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Integer getPrice(Integer bid) {
		String sql = "select price from book where bid=?";
		Object[] args = new Object[] { bid };// ? 的資料
		return jdbcTemplate.queryForObject(sql, args, Integer.class);// Integer.class回傳型別
	}

	@Override
	public Integer UpdateStock(Integer bid) throws InsufficientQuantity {
		// 檢查庫存
		String sql = "select amount from stock where bid=?";
		Object[] args = new Object[] { bid };// ? 的資料
		int amount = jdbcTemplate.queryForObject(sql, args, Integer.class);
		if (amount <= 0) {
			throw new InsufficientQuantity();
		}
		// 修改庫存
		sql = "update stock set amount=amount-1 where bid=?";
		return jdbcTemplate.update(sql, args);
	}

	@Override
	public Integer UpdateWallet(Integer wid, Integer money) throws InsufficientAmount {
		// 檢查餘額是否不足
		String sql = "select money from wallet where wid=?";
		Object[] args = new Object[] { wid };// ? 的資料
		int walletMoney = jdbcTemplate.queryForObject(sql, args, Integer.class);
		if (walletMoney < money) {
			throw new InsufficientAmount();
		}
		// 修改餘額
		sql = "update wallet set money=money-? where wid=?";
		args = new Object[] { money, wid };// ? 的資料
		return jdbcTemplate.update(sql, args);
	}

}
