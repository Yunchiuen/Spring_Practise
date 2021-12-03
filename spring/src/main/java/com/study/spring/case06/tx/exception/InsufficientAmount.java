package com.study.spring.case06.tx.exception;

//餘額不足例外
public class InsufficientAmount extends Throwable {
	public InsufficientAmount() {
		super("Wallet 餘額不足");
	}
}
