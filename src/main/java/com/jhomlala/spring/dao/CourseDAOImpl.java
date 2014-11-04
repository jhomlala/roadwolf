package com.jhomlala.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.jhomlala.spring.model.Course;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

/**
 * An implementation of the ContactDAO interface.
 * @author www.codejava.net
 *
 */
public class CourseDAOImpl implements CourseDAO {

	private JdbcTemplate jdbcTemplate;
	
	public CourseDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	

	@Override
	public void delete(int contactId) {
		String sql = "DELETE FROM contact WHERE contact_id=?";
		jdbcTemplate.update(sql, contactId);
	}

	

	@Override
	public Course get(int contactId) {
		String sql = "SELECT * FROM courses WHERE COURSEID=" + contactId;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Course>() {

			@Override
			public Course extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Course course = new Course(
							rs.getInt("COURSEID"),
							rs.getInt("FROMID"), 
							rs.getInt("TOID"), 
							rs.getString("DEPARTURETIME"), 
							rs.getString("ARRIVALTIME"), 
							rs.getString("SYMBOLS")
						 
						);
					return course;
				}
				
				return null;
			}
			
		});
	}



	@Override
	public List<Course> listCourses() 
	{
		 String SQL = "select * from courses";
	     List <Course> courses = jdbcTemplate.query(SQL, 
                  new CourseMapper());
	      return courses;
	}

}
