package com.study.spring.case06.jdbc;

import java.util.Date;

//Entity
public class Emp {
	private Integer eid;
	private String ename;
	private Integer eage;
	private Date createtime;

	public Emp() {
		super();
	}

	public Emp(String ename, Integer eage) {
		super();
		this.ename = ename;
		this.eage = eage;
	}

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Integer getEage() {
		return eage;
	}

	public void setEage(Integer eage) {
		this.eage = eage;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	@Override
	public String toString() {
		return "Emp [eid=" + eid + ", ename=" + ename + ", eage=" + eage + ", createtime=" + createtime + "]";
	}

}
