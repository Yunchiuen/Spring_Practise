package com.study.spring.case06.jdbc;

import java.sql.ResultSet;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class SelectEmp {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("jdbc-config.xml");
		JdbcTemplate jdbcTemplate=ctx.getBean("jdbcTemplate",JdbcTemplate.class);
		
		//多筆查詢
		String sql="select eid,ename,eage,createtime from emp";
		List<Map<String, Object>> emps= jdbcTemplate.queryForList(sql);
		for(Map<String, Object> emp:emps) {
			System.out.println(emp);
			System.out.println(emp.get("ename"));
		}
		
		//單筆查詢
		//現在emp中有幾筆資料
		sql="select count(*) from emp";
		Integer count= jdbcTemplate.queryForObject(sql, Integer.class);
		System.out.println("資料筆數:"+count);
		
		//多筆查詢 Entity
		sql="select eid,ename,eage,createtime from emp";
		List<Emp> listEmps=jdbcTemplate.query(sql, (ResultSet rs, int rowNum)->{
			Emp emp=new Emp();
			Integer eid= rs.getInt("eid");
			String ename=rs.getString("ename");
			Integer eage=rs.getInt("eage");
			Date createtime=rs.getDate("createtime");
			emp.setEid(eid);
			emp.setEname(ename);
			emp.setEage(eage);
			emp.setCreatetime(createtime);
			return emp;
		});
		System.out.println(listEmps);
		
		//多筆查詢 BeanPropertyRowMapper
		//類似於BeanUtils
		sql="select eid,ename,eage,createtime from emp";
		List<Emp> listEmps2=jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Emp.class));
		System.out.println(listEmps2);
		
	}

}
