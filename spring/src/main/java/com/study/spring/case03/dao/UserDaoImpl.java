package com.study.spring.case03.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
	public UserDaoImpl() {
		System.out.println("UserDaoImpl");
	}

	@Override
	public void createUser() {
		// TODO Auto-generated method stub
		System.out.println("Create User ok");
	}
}
