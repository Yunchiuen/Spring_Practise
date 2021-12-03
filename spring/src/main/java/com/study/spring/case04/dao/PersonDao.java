package com.study.spring.case04.dao;

import java.util.List;

import com.study.spring.case04.model.Person;

public interface PersonDao {
	public boolean add(Person person);

	public List<Person> queryAll();
	
	
}
