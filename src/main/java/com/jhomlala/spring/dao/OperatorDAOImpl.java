package com.jhomlala.spring.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.jhomlala.spring.model.Operator;

public class OperatorDAOImpl implements OperatorDAO 
{
	private JdbcTemplate jdbcTemplate;
	public OperatorDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	
	@Override
	public Operator listOperatorWithID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Operator> listAllOperators() {
		String SQL = "select * from operator";
		List <Operator> listOperator = jdbcTemplate.query(SQL, new OperatorMapper());
	      jdbcTemplate.query(SQL, new OperatorMapper());
		return listOperator;
	}

}
