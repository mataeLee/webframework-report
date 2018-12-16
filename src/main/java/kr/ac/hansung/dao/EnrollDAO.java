package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Enrolment;

@Repository
public class EnrollDAO {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		System.out.println(dataSource);
	}
	
	public int getRowCount() {
		String sqlStatement = "select count(*) from enrolment";
		return jdbcTemplate.queryForObject(sqlStatement, Integer.class);
		
	}
	// 하나의 레코드
	public Enrolment getEnrolment(String name) {
		String sqlStatement = "select *from enrolment where name=?";
		
		// 1번째는 sql 문 2번째 인자는 ? 부분
		// 3번째 인자의 역할 : DB에서 읽은 레코드 값(resultset) 을 객체에다가 맵핑을 시켜주는 객체
		return jdbcTemplate.queryForObject(sqlStatement, new Object[] {name}, new RowMapper<Enrolment>() {

			@Override
			public Enrolment mapRow(ResultSet rs, int rowNum) throws SQLException {
				Enrolment enrolment = new Enrolment();
				enrolment.setUsername(rs.getString("username"));
				enrolment.setYear(rs.getString("year"));
				enrolment.setSemester(rs.getString("semester"));
				enrolment.setCode(rs.getString("code"));
				enrolment.setCores(rs.getString("cores"));
				enrolment.setDivision(rs.getString("division"));
				enrolment.setGrades(rs.getInt("grades"));
				return enrolment;
			}
		});
	}
	// 여러개 레코드
	public List<Enrolment> getEnrolments() {
		String sqlStatement = "select *from enrolment";
		
		// 1번째는 sql 문 2번째 인자는 ? 부분
		// 3번째 인자의 역할 : DB에서 읽은 레코드 값(resultset) 을 객체에다가 맵핑을 시켜주는 객체
		return jdbcTemplate.query(sqlStatement,new RowMapper<Enrolment>() {

			@Override
			public Enrolment mapRow(ResultSet rs, int rowNum) throws SQLException {
				Enrolment enrolment = new Enrolment();
				enrolment.setUsername(rs.getString("username"));
				enrolment.setYear(rs.getString("year"));
				enrolment.setSemester(rs.getString("semester"));
				enrolment.setCode(rs.getString("code"));
				enrolment.setCores(rs.getString("cores"));
				enrolment.setDivision(rs.getString("division"));
				enrolment.setGrades(rs.getInt("grades"));
				return enrolment;
			}
		});
	}
	//
	public boolean insert(Enrolment enrolment) {
		String username = enrolment.getUsername();
		String year = enrolment.getYear();
		String semester = enrolment.getSemester();
		String code = enrolment.getCode();
		String cores = enrolment.getCores();
		String division = enrolment.getDivision();
		int grades = enrolment.getGrades();
		
		String sqlStatement = "insert into enrolment (username, year, semester, code, cores, division, grades) values (?,?,?,?,?,?,?)";
		
		return (jdbcTemplate.update(sqlStatement, new Object[] {username, year, semester, code, cores, division, grades}) == 1);
		
	}
	
/*	public boolean update(Offer offer) {
		
		int id = offer.getId();
		String name = offer.getName();
		String email = offer.getEmail();
		String text = offer.getText();
		System.out.println(id);
		String sqlStatement = "update offers set name=?, email=?, text=?, where id=?";
		
		return (jdbcTemplate.update(sqlStatement, new Object[] {name, email, text, id}) == 1);
		
	}*/
	
/*	public boolean delete(int id) {
		String sqlStatement = "delete from offers where id=?";
		
		return (jdbcTemplate.update(sqlStatement, new Object[] {id}) == 1);
	}*/
}
