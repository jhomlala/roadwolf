package com.jhomlala.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.jhomlala.spring.model.Course;
import com.jhomlala.spring.model.Stop;
import com.jhomlala.spring.model.Time;

public class BusStopDAOImpl implements BusStopDAO {

	private JdbcTemplate jdbcTemplate;
	
	public BusStopDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	

	@Override
	public void delete(int  stopID) {
		String sql = "DELETE FROM busstop WHERE BUSSTOPID=?";
		jdbcTemplate.update(sql, stopID);
	}

	

	@Override
	public Stop get(int stopID) {
		String sql = "SELECT * FROM stop WHERE STOP_ID=" + stopID;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Stop>() {

			@Override
			public Stop extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Stop busStop = new Stop(
							rs.getInt("STOP ID"),
							rs.getInt("COURSE_ID"),
							rs.getInt("CITY_ID"),
							new Time(rs.getString("ARRIVAL_TIME")),
							new Time(rs.getString("DEPARTURE_TIME"))
						);
					return busStop;
				}
				
				return null;
			}
			
		});
	}



	@Override
	public List<Stop> listStopsWithID(int courseID) {
		String SQL = "select * from stop where COURSE_ID = "+courseID;
	     List <Stop> stopList = jdbcTemplate.query(SQL, new BusStopMapper());
	      jdbcTemplate.query(SQL, new BusStopMapper());
		return stopList;
	}


}
