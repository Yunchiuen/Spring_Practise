package com.study.spring.case01;

public class Husband {
	private String name;
	private Wife wife;

	public Husband() {
	}

	public Husband(String name, Wife wife) {
		super();
		this.name = name;
		this.wife = wife;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Wife getWife() {
		return wife;
	}

	public void setWife(Wife wife) {
		this.wife = wife;
	}

	@Override
	public String toString() {
		return  name + " 的老婆是 " + wife.getName() ;
	}

}
