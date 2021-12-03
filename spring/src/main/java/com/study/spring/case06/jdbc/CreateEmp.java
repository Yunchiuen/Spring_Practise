package com.study.spring.case06.jdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

public class CreateEmp {
	ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
	JdbcTemplate jdbcTemplate = ctx.getBean("jdbcTemplate", JdbcTemplate.class);

	@Test
	public void test() {
		case3();

	}

	// 單筆新增
	public void case1() {
		String sql = "insert into emp(ename,eage) values(?,?)";
		jdbcTemplate.update(sql, "jojo", "21");
		System.out.println("insert ok 1");
	}

	// 多筆新增 | 沒有Emp物件情況下
	public void case2() {
		String sql = "insert into emp(ename,eage) values(?,?)";
		List<Object[]> list=new ArrayList<>();
		list.add(new Object[] {"YunEn","23"});
		list.add(new Object[] {"SSSSS","28"});
		list.add(new Object[] {"King","24"});
		int rows[]= jdbcTemplate.batchUpdate(sql, list);
		System.out.println(Arrays.toString(rows));
	}

	// 多筆新增 ||
	public void case3() {
		String sql = "Insert into emp(ename,eage) values(?,?)";
		
		List<Emp> emps=Arrays.asList(
					new Emp("Queen", 26),
					new Emp("Jack", 22)
		);
		BatchPreparedStatementSetter setter= new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				//i=emps的index
				ps.setString(1, emps.get(i).getEname());
				ps.setInt(2, emps.get(i).getEage());
			}
			
			@Override
			public int getBatchSize() {
				
				return emps.size();
			}
		};
		int rows[]= jdbcTemplate.batchUpdate(sql, setter);
		System.out.println(Arrays.toString(rows));
	}
}
