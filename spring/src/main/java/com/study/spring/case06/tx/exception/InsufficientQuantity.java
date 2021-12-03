package com.study.spring.case06.tx.exception;

//庫存數量不足例外
public class InsufficientQuantity extends Throwable {
	public InsufficientQuantity() {
		super("Stock 庫存數量不足");
	}
}
