package com.jhomlala.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.jhomlala.spring.model.Operator;
import com.jhomlala.spring.model.Stop;

public class OperatorMapper implements RowMapper<Operator> 
{
	public Operator mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		Operator operator = new Operator();
		operator.setId(rs.getInt("OPERATOR_ID"));
		operator.setOperatorName(rs.getString("NAME"));
		operator.setOperatorDescription("DESCRIPTION");
		return operator;
	}
}
