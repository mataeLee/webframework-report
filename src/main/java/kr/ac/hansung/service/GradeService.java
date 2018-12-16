package kr.ac.hansung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.GradeDAO;
import kr.ac.hansung.model.Grade;

@Service
public class GradeService {
	@Autowired
	private GradeDAO gradeDAO;
	
	public List<Grade> getCurrent() {
		return gradeDAO.getGrades();
	}
	
	public List<Grade> getWantGrades(String year, String semester){
		List<Grade> list = gradeDAO.getWantGrades(year, semester);
		
		return list;
	}
	
}
