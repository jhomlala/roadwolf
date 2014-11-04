package com.jhomlala.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.jhomlala.spring.model.BusStop;
import com.jhomlala.spring.model.Course;

public class BusStopDAOImpl implements BusStopDAO {

	private JdbcTemplate jdbcTemplate;
	
	public BusStopDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	

	@Override
	public void delete(int contactId) {
		String sql = "DELETE FROM busstop WHERE BUSSTOPID=?";
		jdbcTemplate.update(sql, contactId);
	}

	

	@Override
	public BusStop get(int contactId) {
		String sql = "SELECT * FROM busstop WHERE BUSSTOPID=" + contactId;
		return jdbcTemplate.query(sql, new ResultSetExtractor<BusStop>() {

			@Override
			public BusStop extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					BusStop busStop = new BusStop(
							rs.getInt("BUSSTOPID"),
							rs.getString("NAME") 
						 
						);
					return busStop;
				}
				
				return null;
			}
			
		});
	}


}
