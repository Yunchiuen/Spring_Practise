package com.study.spring.case01;

public class Wife {
	private String name;
	private Husband husband;

	public Wife() {
	}

	public Wife(String name, Husband husband) {
		super();
		this.name = name;
		this.husband = husband;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Husband getHusband() {
		return husband;
	}

	public void setHusband(Husband husband) {
		this.husband = husband;
	}

	@Override
	public String toString() {
		return name + " 的丈夫是 " + husband.getName() ;
	}

}
