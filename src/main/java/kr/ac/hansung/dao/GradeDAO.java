package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Grade;

@Repository
public class GradeDAO {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		System.out.println(dataSource);
	}
	
	public int getRowCount() {
		String sqlStatement = "select count(*) from grade";
		return jdbcTemplate.queryForObject(sqlStatement, Integer.class);
		
	}
	// 하나의 레코드
	public Grade getGrade(String name) {
		String sqlStatement = "select *from grade where name=?";
		
		// 1번째는 sql 문 2번째 인자는 ? 부분
		// 3번째 인자의 역할 : DB에서 읽은 레코드 값(resultset) 을 객체에다가 맵핑을 시켜주는 객체
		return jdbcTemplate.queryForObject(sqlStatement, new Object[] {name}, new RowMapper<Grade>() {
			@Override
			public Grade mapRow(ResultSet rs, int rowNum) throws SQLException {
				Grade grade = new Grade();
				grade.setUsername(rs.getString("username"));
				grade.setYear(rs.getString("year"));
				grade.setSemester(rs.getString("semester"));
				grade.setCode(rs.getString("code"));
				grade.setDivision(rs.getString("division"));
				grade.setGrades(rs.getInt("grades"));
				return grade;
			}
		});
	}
	// 여러개 레코드
	public List<Grade> getGrades() {
		String sqlStatement = "select *from grade";
		
		// 1번째는 sql 문 2번째 인자는 ? 부분
		// 3번째 인자의 역할 : DB에서 읽은 레코드 값(resultset) 을 객체에다가 맵핑을 시켜주는 객체
		return jdbcTemplate.query(sqlStatement,new RowMapper<Grade>() {

			@Override
			public Grade mapRow(ResultSet rs, int rowNum) throws SQLException {
				Grade grade = new Grade();
				grade.setUsername(rs.getString("username"));
				grade.setYear(rs.getString("year"));
				grade.setSemester(rs.getString("semester"));
				grade.setCode(rs.getString("code"));
				grade.setCores(rs.getString("cores"));
				grade.setDivision(rs.getString("division"));
				grade.setGrades(rs.getInt("grades"));
				return grade;
			}
		});
	}
	
	public List<Grade> getWantGrades(String year, String semester){
		String sqlStatement = "select * from grade where year=? and semester=?";
		
		return jdbcTemplate.query(sqlStatement, new Object[] {year, semester}, new RowMapper<Grade>() {

			@Override
			public Grade mapRow(ResultSet rs, int rowNum) throws SQLException {
				Grade grade = new Grade();
				grade.setUsername(rs.getString("username"));
				grade.setYear(rs.getString("year"));
				grade.setSemester(rs.getString("semester"));
				grade.setCode(rs.getString("code"));
				grade.setCores(rs.getString("cores"));
				grade.setDivision(rs.getString("division"));
				grade.setGrades(rs.getInt("grades"));
				return grade;
			}
		});
		
	}
/*	//
	public boolean insert(Grade grade) {
		String username = grade.getUsername();
		String year = grade.getYear();
		String semester = grade.getSemester();
		String code = grade.getCode();
		String cores = grade.getCores();
		String division = grade.getDivision();
		int grades = grade.getGrades();
		
		String sqlStatement = "insert into offers (name, email, text) values (?,?,?)";
		
		return (jdbcTemplate.update(sqlStatement, new Object[] {name, email, text}) == 1);
		
	}*/
	
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
