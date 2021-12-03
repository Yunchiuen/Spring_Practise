package com.study.spring.case03.model;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
//classpath 就是main下的路徑
@PropertySource("classpath:user.properties")
public class User {
	//@Value(value = "john")
	@Value(value = "${user.name1}")
	private String name;

	//@Value(value = "18")
	@Value(value = "${user.age}")
	private Integer age;

	//@Value(value = "#{${nikename : {'Happy','Enjoy'}}}")//Spring EL
	@Value(value = "${user.nikename}")
	private String[] nikename;// 暱稱

	//@Value(value = "#{${subject : {'國文','英文','數學'}}}")
	@Value(value="${user.subject}")
	private Set<String> subject;// 科目

	//@Value(value = "#{${scores : {50,70,50}}}")
	@Value(value = "#{'${user.scorees}'.split(',')}")
	private List<Integer> scores;

	//@Value(value = "#{${hobbies : {key1: 'car' , key2: 'Airplane'}}}")
	@Value(value = "#{${user.hobbies}}")
	private Map<String, String> hobbies;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String[] getNikename() {
		return nikename;
	}

	public void setNikename(String[] nikename) {
		this.nikename = nikename;
	}

	public Set<String> getSubject() {
		return subject;
	}

	public void setSubject(Set<String> subject) {
		this.subject = subject;
	}

	public List<Integer> getScores() {
		return scores;
	}

	public void setScores(List<Integer> scores) {
		this.scores = scores;
	}

	public Map<String, String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(Map<String, String> hobbies) {
		this.hobbies = hobbies;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", nikename=" + Arrays.toString(nikename) + ", subject="
				+ subject + ", scores=" + scores + ", hobbies=" + hobbies + "]";
	}

}
