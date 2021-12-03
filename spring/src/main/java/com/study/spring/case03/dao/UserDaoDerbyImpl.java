package com.study.spring.case03.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoDerbyImpl implements UserDao {
	public UserDaoDerbyImpl() {
		System.out.println("UserDaoDerbyImpl");
	}

	@Override
	public void createUser() {
		// TODO Auto-generated method stub
		System.out.println("Create User ok from Derby");
	}

}
