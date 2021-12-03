package com.study.spring.case04.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.spring.case04.JsonDB;
import com.study.spring.case04.model.Person;

@Repository
public class PersonDaoImpl implements PersonDao {
	@Autowired
	private JsonDB jsonDB;

	@Override
	public boolean add(Person person) {
		try {
			return jsonDB.add(person);
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		return false;
	}

	@Override
	public List<Person> queryAll() {
		try {
			return jsonDB.queryAll();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		return null;
	}

}
