package com.study.spring.case04.service;

import java.util.List;

import com.study.spring.case04.model.Person;

public interface PersonService {
	boolean append(Person person);

	List<Person> findAll();
}
