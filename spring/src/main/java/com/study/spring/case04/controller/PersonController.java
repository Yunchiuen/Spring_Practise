package com.study.spring.case04.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.study.spring.case04.model.Person;
import com.study.spring.case04.service.PersonService;

@Controller
public class PersonController {
	@Autowired
	private PersonService personService;

	public boolean addPerson(String name, Date birth) {
		Person person = new Person();
		person.setName(name);
		person.setBirth(birth);
		
		person.setAge(findDifference(birth));
		
		return personService.append(person);

	}

	public List<Person> queryPerson() {
		return personService.findAll();
	}
	
	public Integer findDifference(Date birth) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

		try {
			String s_birth= sdf.format(birth);
			String s_end= sdf.format(new Date());
			Date d1 = sdf.parse(s_birth);
			Date d2 = sdf.parse(s_end);

			
			long difference_In_Time = d2.getTime() - d1.getTime();

			//long difference_In_Seconds = (difference_In_Time / 1000) % 60;

			//long difference_In_Minutes = (difference_In_Time / (1000 * 60)) % 60;

			//long difference_In_Hours = (difference_In_Time / (1000 * 60 * 60)) % 24;

			Integer difference_In_Years = (int) (difference_In_Time / (1000L * 60 * 60 * 24 * 365));

			//long difference_In_Days = (difference_In_Time / (1000 * 60 * 60 * 24)) % 365;


			
			return difference_In_Years;
		}

		catch (ParseException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
